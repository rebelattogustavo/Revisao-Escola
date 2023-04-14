package com.example.revisaoescola.DTO;

import com.example.revisaoescola.model.entities.Professor;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class DisciplinaDTO {

    String nome;

    List<Professor> listaDeProfessores;

}
