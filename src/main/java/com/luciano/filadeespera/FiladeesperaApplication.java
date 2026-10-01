package com.luciano.filadeespera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.MenuRecepcao;

import java.awt.*;

@SpringBootApplication
public class FiladeesperaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiladeesperaApplication.class, args);
        MenuRecepcao menuRecepcao = new MenuRecepcao();
        menuRecepcao.menuRecepcao();
	}

}
