package com.projretohd.menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projretohd.entities.Address;
import com.projretohd.entities.Clients;
import com.projretohd.entities.CompanyClient;
import com.projretohd.entities.IndividualClient;
import com.projretohd.services.ClientsService;


@Component
public class MenuConsole {


@Autowired
private ClientsService clientsService;

public void showMenu() {
    try (Scanner scanner = new Scanner(System.in)) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
		    while (true) {
		        System.out.println("Escolha um comando:");
		        System.out.println("1-Cadastrar");
		        System.out.println("2-Pesquisar");
		        System.out.println("3-Excluir usuário");
		        System.out.println("4-Alterar");
		        System.out.println("5-Achar credores");
		        System.out.println("6-Sair");

		        int option = scanner.nextInt();
		        scanner.nextLine();

		        if (option == 1) {
		            System.out.println("Pessoa física ou jurídica? Digite: 1-Física ou 2-Jurídica: ");
		            int personType = scanner.nextInt();
		            scanner.nextLine();

		            if (personType == 1) {
		                System.out.print("CPF: ");
		                String cpf = scanner.nextLine();
		                if (cpf == null || cpf.trim().isEmpty()) {
		                    System.out.println("Erro: O CPF não pode ser vazio.");
		                    continue;
		                }

		                System.out.print("Nome: ");
		                String name = scanner.nextLine();

		                

		                System.out.print("data nascimento: ");
		                String birthDateStr = scanner.nextLine();
		                LocalDate birthDate = LocalDate.parse(birthDateStr, dateFormat);

		                System.out.print("Telefone: ");
		                String phone = scanner.nextLine();

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

		                IndividualClient client = new IndividualClient(cpf, name, phone, email, address, birthDate);
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

		                System.out.print("Nome: ");
		                String name = scanner.nextLine();

		                System.out.print("Telefone: ");
		                String phone = scanner.nextLine();

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

		                CompanyClient client = new CompanyClient(cnpj, name, phone, email, address, companyName);
		                clientsService.saveClient(client);
		                
		            }

		        } else if (option == 2) {
		            System.out.print("Digite o nome do cliente: ");
		            String name = scanner.nextLine();

		            List<Clients> foundClients = clientsService.findByName(name);

		            if (foundClients.isEmpty()) {
		                System.out.println("Nenhum cliente encontrado.");
		            } else {
		                System.out.println("Clientes encontrados:");
		                for (Clients c : foundClients) {
		                    System.out.println(c);
		                }
		            }
		        }
		        // Os outros casos (3 a 6) ainda podem ser completados
		    }
		} catch (Exception e) {
		    System.out.println("Erro geral: " + e.getMessage());
		}
	}
}}