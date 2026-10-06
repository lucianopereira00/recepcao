package com.luciano.filadeespera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.GerenciadorDeFila;
import service.MenuAtendimento;
import service.MenuAdm;
import service.MenuInicial;

import java.util.Scanner;

@SpringBootApplication
public class FiladeesperaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiladeesperaApplication.class, args);
		new MenuInicial().menuInicial();
	}
}