package com.luciano.filadeespera.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "remedio_id")
    private Remedio remedio;

    private LocalDateTime dataPedido = LocalDateTime.now();

    public Pedido(Remedio remedio) {
        this.remedio = remedio;
    }

    public Long getId() {
        return id;
    }

    public Remedio getRemedio() {
        return remedio;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }
}
