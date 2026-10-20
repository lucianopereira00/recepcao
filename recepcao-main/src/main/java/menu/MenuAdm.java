package menu;

import farmacia.farmaciaMenu;
import service.GerenciadorDeFila;

import java.util.Scanner;
// Se GerenciadorDeFila estiver no mesmo pacote 'service', o import não é obrigatório,
// mas garanta que o arquivo GerenciadorDeFila.java está criado dentro dessa mesma pasta.

public class MenuAdm {
    private Scanner sc = new Scanner(System.in);
    private GerenciadorDeFila gerenciador2 = new GerenciadorDeFila();
    private farmaciaMenu farmaciaMenu = new farmaciaMenu();

    public void menuAdministrativo(GerenciadorDeFila gerenciador) {
        String opc = "";

        while (!opc.equals("3")) {
            System.out.println("\n--- Painel Administrativo / Recepção ---");
            System.out.println("1. Ver relatório de pacientes por nível");
            System.out.println("2. Acionar ambulância");
            System.out.println("3. Farmácia");
            System.out.println("4. Lista geral de pacientes");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Opção desejada: ");

            opc = sc.nextLine();

            switch (opc) {
                case "1":
                    gerenciador.exibirRelatorioGeral();
                    break;
                case "2":
                    int emg = gerenciador.getQuantidadePacientesNivel("5");
                    System.out.println("\n[ALERTA] Ambulância acionada! Pacientes em emergência: " + emg);
                    break;
                case "3":
                    farmaciaMenu.menuFarmacia();
                    break;
                case "4":
                    gerenciador.exibirTodosPacientes();
                    break;
                case "5":
                    System.out.println("Retornando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}