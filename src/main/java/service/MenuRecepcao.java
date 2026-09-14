package service;

import java.util.Scanner;

public class MenuRecepcao {
    Scanner sc = new Scanner(System.in);
    public void menuRecepcao(){
        System.out.println("\n---Menu Recepção---");

        System.out.println("\nSelecione o nível do seu caso:");

        System.out.println("1. Não urgente");
        System.out.println("2. Pouco urgente");
        System.out.println("3. Urgente");
        System.out.println("4. Muito urgente");
        System.out.println("5. Emergência");
        System.out.println("6. Sair\n");

        System.out.println("Opção desejada:");
        String opcMenu = sc.nextLine();

        while (!opcMenu.matches("[1-6]")) {
            System.out.println("Opção inválida! Digite novamente:");
            opcMenu = sc.nextLine();
        }

        NivelEmergencia nivel = new NivelEmergencia();
        nivel.verificarOcorrencia(opcMenu);

    }
}
