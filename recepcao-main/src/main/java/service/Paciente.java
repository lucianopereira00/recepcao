package service;


public class Paciente {
    private String nome;
    private int nivel;

    public Paciente(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }
}

