package com.projetohd.menu;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetohd.entities.Product;
import com.projetohd.services.ProductService;

@Component
public class MenuProductConsole {

    @Autowired
    private ProductService productService;

    public void showProductMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n===== MENU DE PRODUTOS =====");
                System.out.println("1 – Cadastrar produto");
                System.out.println("2 – Buscar produto por ID");
                System.out.println("3 – Buscar produto por nome");
                System.out.println("4 – Excluir produto por ID");
                System.out.println("5 – Excluir produto por nome");
                System.out.println("0 – Voltar");
                System.out.print("> ");

                String opcao = scanner.nextLine().trim();

                switch (opcao) {
                    case "1" -> cadastrarProduto(scanner);
                    case "2" -> buscarPorId(scanner);
                    case "3" -> buscarPorNome(scanner);
                    case "4" -> excluirPorId(scanner);
                    case "5" -> excluirPorNome(scanner);
                    case "0" -> { return; }
                    default  -> System.out.println("Opção inválida, tente novamente.");
                }
            }
        }
    }

    /* ---------- Operações ---------- */

    private void cadastrarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String name = scanner.nextLine().trim();

        if (productService.existsByName(name).isPresent()) {
            System.out.println("❌ Já existe um produto com esse nome.");
            return;
        }

        System.out.print("Preço (ex.: 149.90): ");
        BigDecimal price = new BigDecimal(scanner.nextLine().trim());

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productService.saveProduct(product);

        System.out.println("✅ Produto cadastrado com sucesso!");
        System.out.println(product);
    }

    private void buscarPorId(Scanner scanner) {
        System.out.print("ID do produto: ");
        Long id = Long.parseLong(scanner.nextLine().trim());

        Optional<Product> opt = productService.findById(id);
        opt.ifPresentOrElse(
                p -> System.out.println("➡️  Encontrado: " + p),
                () -> System.out.println("❌ Produto não encontrado.")
        );
    }

    private void buscarPorNome(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String name = scanner.nextLine().trim();

        Optional<Product> opt = productService.existsByName(name);
        opt.ifPresentOrElse(
                p -> System.out.println("➡️  Encontrado: " + p),
                () -> System.out.println("❌ Produto não encontrado.")
        );
    }

    private void excluirPorId(Scanner scanner) {
        System.out.print("ID para excluir: ");
        Long id = Long.parseLong(scanner.nextLine().trim());

        productService.deleteById(id);
        System.out.println("✅ Exclusão concluída (se o ID existia).");
    }

    private void excluirPorNome(Scanner scanner) {
        System.out.print("Nome para excluir: ");
        String name = scanner.nextLine().trim();

        productService.deleteByName(name);
        System.out.println("✅ Exclusão concluída (se o nome existia).");
    }
}
