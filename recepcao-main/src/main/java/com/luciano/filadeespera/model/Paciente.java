package com.luciano.filadeespera.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Pacientes")
@NoArgsConstructor
@Getter
public class Paciente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String nivel;

    public Paciente(String nome, int idade, String nivel) {
        this.nome = nome;
        this.idade = idade;
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return nome + " - " + idade + " anos - nível " + nivel;
    }
}