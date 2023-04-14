package com.example.revisaoescola.repository;

import com.example.revisaoescola.model.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
