package com.luciano.filadeespera.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    boolean existsByNomeRemedio(String nome);
    Optional<Remedio> findByNomeRemedio(String nome);
    Optional<Remedio> findByNomeRemedioIgnoreCase(String nome);
    List<Remedio> findAllByOrderByNomeRemedioAsc();
}
