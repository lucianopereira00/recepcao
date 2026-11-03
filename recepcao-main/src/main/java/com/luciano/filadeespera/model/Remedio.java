package com.luciano.filadeespera.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Remedio")
@NoArgsConstructor
@Getter
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_remedio;

    public Remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    @Override
    public String toString() {
        return "Nome do remedio: " + nome_remedio;
    }
}
