package com.projetohd.menu;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MenuChoice {
	@Autowired
	private MenuProductConsole menuProductConsole;

	@Autowired
	private MenuServiceOfferedConsole menuServiceConsole;   // crie um console parecido com o de produtos

	public void showMenu(Scanner scanner) {
	    while (true) {
	        System.out.println("\nO que você deseja gerenciar?");
	        System.out.println("1 – Produtos");
	        System.out.println("2 – Serviços");
	        System.out.println("0 – Voltar");
	        System.out.print("> ");

	        String entrada = scanner.nextLine();
	        switch (entrada) {
	            case "1" -> { menuProductConsole.showProductMenu(); return; }
	            case "2" -> { menuServiceConsole.showServiceMenu(); return; }
	            case "0" -> { return; }                       // volta para o menu anterior
	            default  ->   System.out.println("Opção inválida, tente de novo.");
	        }
	    }
	}

}
