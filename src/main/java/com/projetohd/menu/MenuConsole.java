package com.projetohd.menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetohd.entities.Address;
import com.projetohd.entities.Clients;
import com.projetohd.entities.CompanyClient;
import com.projetohd.entities.IndividualClient;
import com.projetohd.entities.User;
import com.projetohd.entities.UserRole;
import com.projetohd.services.ClientsService;
import com.projetohd.services.UserService;

@Component
public class MenuConsole {
	@Autowired
	private MenuChoice menuChoice;


    @Autowired
    private ClientsService clientsService;

    @Autowired
    private UserService userService;

    public void showMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {
                while (true) {
                    System.out.println("Escolha um comando:");
                    System.out.println("1 - Cadastrar Usuário");
                    System.out.println("2 - Cadastrar Cliente");
                    System.out.println("3 - Pesquisar Cliente");
                    System.out.println("4 - Login");
                    System.out.println("5 - Alterar Cliente");
                    System.out.println("6 - Achar Credores");
                    System.out.println("7 - Sair");

                    int option = scanner.nextInt();
                    scanner.nextLine();

                    if (option == 1) {
                        System.out.print("nome de usúario: ");
                        String username = scanner.nextLine();
                        if (userService.existsByUsername(username)) {
                            System.out.println("Erro: Nome de usuário já existe.");
                            continue;
                        }

                        System.out.print("Senha: ");
                        String password = scanner.nextLine();

                        System.out.print("Role (ADMIN, MANAGER, USER): ");
                        String roleStr = scanner.nextLine().toUpperCase();
                        UserRole role = UserRole.valueOf(roleStr);

                        System.out.print("Nome completo: ");
                        String fullName = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.println("Agora, informe o endereço:");
                        System.out.print("Rua: ");
                        String street = scanner.nextLine();

                        System.out.print("Número: ");
                        String number = scanner.nextLine();

                        System.out.print("Bairro: ");
                        String district = scanner.nextLine();

                        System.out.print("Cidade: ");
                        String city = scanner.nextLine();

                        System.out.print("Estado: ");
                        String state = scanner.nextLine();

                        System.out.print("CEP: ");
                        String zip = scanner.nextLine();

                        System.out.print("País: ");
                        String country = scanner.nextLine();

                        Address address = new Address(street, number, district, city, state, zip, country);

                        User user = new User(username, password, role, fullName, email, address);
                        userService.saveUser(user);

                        System.out.println("Usuário cadastrado com sucesso!");
                    }


                    else if (option == 2) {
                        System.out.println("Pessoa física ou jurídica? Digite: 1-Física ou 2-Jurídica: ");
                        int personType = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("nome completo: ");
                        String fullname = scanner.nextLine();
                        
                        System.out.print("nome de usuario: ");
                        String username = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String phone = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        
                        System.out.print("Senha: ");
                        String password = scanner.nextLine();

                        System.out.println("Agora, informe o endereço:");
                        System.out.print("Rua: ");
                        String street = scanner.nextLine();

                        System.out.print("Número: ");
                        String number = scanner.nextLine();

                        System.out.print("Bairro: ");
                        String district = scanner.nextLine();

                        System.out.print("Cidade: ");
                        String city = scanner.nextLine();

                        System.out.print("Estado: ");
                        String state = scanner.nextLine();

                        System.out.print("CEP: ");
                        String zip = scanner.nextLine();

                        System.out.print("País: ");
                        String country = scanner.nextLine();

                        Address address = new Address(street, number, district, city, state, zip, country);

                        if (personType == 1) {
                            System.out.print("CPF: ");
                            String cpf = scanner.nextLine();
                            if (cpf == null || cpf.trim().isEmpty()) {
                                System.out.println("Erro: O CPF não pode ser vazio.");
                                continue;
                            }

                            System.out.print("Data de nascimento (dd/MM/yyyy): ");
                            String birthDateStr = scanner.nextLine();
                            LocalDate birthDate = LocalDate.parse(birthDateStr, dateFormat);

                            IndividualClient client = new IndividualClient(username,fullname, phone, email,password, address, cpf, birthDate);
                            System.out.println("CPF recebido: " + client.getCpf());
                            clientsService.saveClient(client);
                        } else if (personType == 2) {
                            System.out.print("CNPJ: ");
                            String cnpj = scanner.nextLine();
                            if (cnpj == null || cnpj.trim().isEmpty()) {
                                System.out.println("Erro: O CNPJ não pode ser vazio.");
                                continue;
                            }

                            System.out.print("Razão social: ");
                            String companyName = scanner.nextLine();

                            CompanyClient client = new CompanyClient(cnpj, username,fullname, phone, email,password, address, companyName);
                            clientsService.saveClient(client);
                        }
                    }

                    else if (option == 3) {
                        System.out.print("Digite o nome do cliente: ");
                        String name = scanner.nextLine();

                        List<Clients> foundClients = clientsService.findByUsername(name);
                        if (foundClients.isEmpty()) {
                            System.out.println("Nenhum cliente encontrado.");
                        } else {
                            System.out.println("Clientes encontrados:");
                            for (Clients c : foundClients) {
                                System.out.println(c);
                            }
                        }
                    }else if (option == 4) {
                    	
                    	   System.out.println("Digite seu login:");

                         
                           System.out.print("Email: ");
                           String email = scanner.nextLine();
                           System.out.print("Senha: ");
                           String password = scanner.nextLine();
                        if( userService.login(email, password) != true) {
                        	
                        	
                        }else {
                        	menuChoice.showMenu(scanner);
                        }
                           
                    }

                    else if (option == 7) {
                        System.out.println("Saindo...");
                        System.exit(0);
;
                    }

                    else {
                        System.out.println("Opção inválida.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro geral: " + e.getMessage());
            }
        }
    }
}
