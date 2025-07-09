package com.projretohd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projretohd.menu.MenuConsole;
@SpringBootApplication
public class AdminempresaApplication implements CommandLineRunner {

    @Autowired
    private MenuConsole menuConsole;

    public static void main(String[] args) {
        SpringApplication.run(AdminempresaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menuConsole.showMenu();
    }
}
