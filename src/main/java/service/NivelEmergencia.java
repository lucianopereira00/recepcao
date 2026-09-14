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
                break;
            case "2":
                System.out.println("Opcao selecionada:"+opcMenu);
                poucoUrgente(opcMenu);
                break;
            case "3":
                System.out.println("Opcao selecionada:"+opcMenu);
                break;
            case "4":
                System.out.println("Opcao selecionada:"+opcMenu);
                break;
            case "5":
                System.out.println("Opcao selecionada:"+opcMenu);
                break;
            case "6":
                System.out.println("Opcao selecionada:"+opcMenu);
                break;
            default:
                return;
        }
    }

    public void poucoUrgente(String opcMenu){
        System.out.println("\n - POUCO URGENTE");
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
