package com.projetohd.menu;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetohd.entities.ServiceOffered;
import com.projetohd.services.ServiceOfferedService;

@Component
public class MenuServiceOfferedConsole {

    @Autowired
    private ServiceOfferedService serviceOfferedService;

    public void showServiceMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n===== MENU DE SERVIÇOS =====");
                System.out.println("1 – Cadastrar serviço");
                System.out.println("2 – Buscar serviço por ID");
                System.out.println("3 – Buscar serviço por nome");
                System.out.println("4 – Excluir serviço por ID");
                System.out.println("5 – Excluir serviço por nome");
                System.out.println("0 – Voltar");
                System.out.print("> ");

                String opcao = scanner.nextLine().trim();

                switch (opcao) {
                    case "1" -> cadastrarServico(scanner);
                    case "2" -> buscarPorId(scanner);
                    case "3" -> buscarPorNome(scanner);
                    case "4" -> excluirPorId(scanner);
                    case "5" -> excluirPorNome(scanner);
                    case "0" -> { return; }   // sai do menu
                    default  -> System.out.println("Opção inválida, tente novamente.");
                }
            }
        }
    }

    

    private void cadastrarServico(Scanner scanner) {
        System.out.print("Nome do serviço: ");
        String name = scanner.nextLine().trim();

        if (serviceOfferedService.existsByName(name).isPresent()) {
            System.out.println("❌ Já existe um serviço com esse nome.");
            return;
        }

        System.out.print("Descrição: ");
        String description = scanner.nextLine().trim();

        System.out.print("Preço (ex.: 199.90): ");
        BigDecimal price = new BigDecimal(scanner.nextLine().trim());

        System.out.print("Duração em minutos: ");
        Integer duration = Integer.parseInt(scanner.nextLine().trim());

        ServiceOffered service = new ServiceOffered(name, description, price, duration);
        serviceOfferedService.save(service);

        System.out.println("✅ Serviço cadastrado com sucesso!");
        System.out.println(service);
    }

    private void buscarPorId(Scanner scanner) {
        System.out.print("ID do serviço: ");
        Long id = Long.parseLong(scanner.nextLine().trim());

        Optional<ServiceOffered> opt = serviceOfferedService.findById(id);
        opt.ifPresentOrElse(
                s -> System.out.println("➡️  Encontrado: " + s),
                () -> System.out.println("❌ Serviço não encontrado.")
        );
    }

    private void buscarPorNome(Scanner scanner) {
        System.out.print("Nome do serviço: ");
        String name = scanner.nextLine().trim();

        Optional<ServiceOffered> opt = serviceOfferedService.existsByName(name);
        opt.ifPresentOrElse(
                s -> System.out.println("➡️  Encontrado: " + s),
                () -> System.out.println("❌ Serviço não encontrado.")
        );
    }

    private void excluirPorId(Scanner scanner) {
        System.out.print("ID para excluir: ");
        Long id = Long.parseLong(scanner.nextLine().trim());

        serviceOfferedService.deleteById(id);
        System.out.println("✅ Exclusão concluída (se o ID existia).");
    }

    private void excluirPorNome(Scanner scanner) {
        System.out.print("Nome para excluir: ");
        String name = scanner.nextLine().trim();

        serviceOfferedService.deleteByName(name);
        System.out.println("✅ Exclusão concluída (se o nome existia).");
    }
}
