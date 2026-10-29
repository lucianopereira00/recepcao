package com.luciano.filadeespera;

import menu.MenuInicial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiladeesperaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiladeesperaApplication.class, args);
		new MenuInicial().menuInicial();
	}
}

// Para usar com janela:
//package com.luciano.filadeespera;
//
//import menu.JanelaInicial;
//import menu.JanelaMenu;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//@SpringBootApplication
//public class FiladeesperaApplication {
//
//	public static void main(String[] args) {
//		new SpringApplicationBuilder(FiladeesperaApplication.class)
//				.headless(false)   // permite abrir janelas Swing
//				.run(args);
//
//		javax.swing.SwingUtilities.invokeLater(() -> new JanelaMenu().setVisible(true));
//	}
//}