package com.luciano.filadeespera.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    boolean existsByNome(String nome);
    Optional<Remedio> findByNome(String nome);
    List<Remedio> findAllByOrderByNomeAsc();
}
