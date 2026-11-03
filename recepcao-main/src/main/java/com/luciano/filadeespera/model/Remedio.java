package com.luciano.filadeespera.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Remedio")
@NoArgsConstructor
@Getter
@Setter
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeRemedio;

    public Remedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    @Override
    public String toString() {
        return "Nome do remedio: " + nomeRemedio;
    }
}
