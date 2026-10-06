package service;

import com.luciano.filadeespera.FiladeesperaApplication;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class MenuInicial {

    Scanner sc = new Scanner(System.in);

    // 1. Criamos um ÚNICO gerenciador que vai guardar os dados o tempo todo
    GerenciadorDeFila gerenciador = new GerenciadorDeFila();

    // 2. Criamos as telas
    MenuAtendimento menuPaciente = new MenuAtendimento();
    MenuAdm menuAdm = new MenuAdm();

    public void menuInicial() {
        String opcao = "";

    // 3. Loop principal para escolher quem está usando o sistema
    while(!opcao.equals("3"))
    {
                System.out.println("\n=== SISTEMA HOSPITALAR ===");
                System.out.println("1. Entrar como Paciente (Fazer Triagem)");
                System.out.println("2. Entrar como ADM / Recepção (Ver Relatório)");
                System.out.println("3. Desligar Sistema");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextLine();

                if (opcao.equals("1")) {
                    // Passamos o gerenciador para o paciente poder adicionar +1
                    menuPaciente.menuRecepcao(gerenciador);
                } else if (opcao.equals("2")) {
                    // Passamos o mesmo gerenciador pro ADM poder ler os dados
                    menuAdm.menuAdministrativo(gerenciador);
                } else if (!opcao.equals("3")) {
                    System.out.println("Opção inválida!");
                }
            }
            sc.close();
        }
    }

