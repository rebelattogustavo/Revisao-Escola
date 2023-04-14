package com.example.revisaoescola.repository;

import com.example.revisaoescola.model.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
