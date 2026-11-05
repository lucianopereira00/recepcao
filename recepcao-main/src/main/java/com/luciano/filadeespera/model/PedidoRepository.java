package com.luciano.filadeespera.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Remedio> findByNomeRemedioIgnoreCase(String nomeRemedio);
}
