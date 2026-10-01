package service;

import java.util.Scanner;

public class NivelEmergencia {
    private int naoUrgente = 1;
    private int poucoUrgente = 2;
    private int urgente = 3;
    private int muitoUrgente = 4;
    private int emergencia = 5;
    private int sair = 6;


    public void verificarOcorrencia(String opcMenu){
        switch(opcMenu){
            case "1":
                System.out.println("Opção selecionada:"+opcMenu);
                naoUrgente(opcMenu);
                break;
            case "2":
                System.out.println("Opcao selecionada:"+opcMenu);
                poucoUrgente(opcMenu);
                break;
            case "3":
                System.out.println("Opcao selecionada:"+opcMenu);
                urgente(opcMenu);
                break;
            case "4":
                System.out.println("Opcao selecionada:"+opcMenu);
                muitoUrgente(opcMenu);
                break;
            case "5":
                System.out.println("Opcao selecionada:"+opcMenu);
                emergencia(opcMenu);
                break;
            case "6":
                System.out.println("Opcao selecionada:"+opcMenu);

                break;
            default:
                return;
        }
    }
    public void naoUrgente(String opcMenu){
        System.out.println("\n - NÃO URGENTE  -\n"+
                "Atendimento em até 4 horas.");
    }

    public void poucoUrgente(String opcMenu){
        System.out.println("\n - POUCO URGENTE - \n" +
                "Atendimento em até 2 horas.");
    }

    public void urgente(String opcMenu){
        System.out.println("\n - URGENTE -\n"+
                "Atendimento em até 1 hora.");
    }
    public void muitoUrgente(String opcMenu){
        System.out.println("\n - MUITO URGENTE - \n"+
                "Atendimento em até 10 minutos.");
    }

    public void emergencia(String opcMenu){
        System.out.println("\n - URGÊNCIA - \n"+
                "Você será atendido(a) imediatamente.");
    }

    public void sair(String opcMenu){
        System.out.println("\n Saindo..."+
                "Menu encerrado!");
    }

    public int getNaoUrgente() {
        return naoUrgente;
    }

    public int getSair() {
        return sair;
    }

    public int getEmergencia() {
        return emergencia;
    }

    public int getMuitoUrgente() {
        return muitoUrgente;
    }

    public int getUrgente() {
        return urgente;
    }

    public int getPoucoUrgente() {
        return poucoUrgente;
    }
}
