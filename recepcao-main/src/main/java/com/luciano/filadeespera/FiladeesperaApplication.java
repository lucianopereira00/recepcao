package com.luciano.filadeespera;

import menu.JanelaInicial;
import menu.JanelaMenu;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FiladeesperaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(FiladeesperaApplication.class)
				.headless(false)   // permite abrir janelas Swing
				.run(args);

		javax.swing.SwingUtilities.invokeLater(() -> new JanelaMenu().setVisible(true));
	}
}