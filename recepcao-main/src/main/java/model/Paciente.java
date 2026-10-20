package model;


public class Paciente {
    private String nome;
    private int idade;
    private String nivel;

    public Paciente(String nome,int idade, String nivel) {
        this.nome = nome;
        this.idade = idade;
        this.nivel = nivel;
    }
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return nome + " - " + idade + " anos - nível " + nivel;
    }
}

