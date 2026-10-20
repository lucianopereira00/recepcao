package model;


public class Paciente {
    private String nome;
    private String nivel;

    public Paciente(String nome, String nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }
    public String getNivel() { return nivel; }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " - nível " + nivel;
    }
}

