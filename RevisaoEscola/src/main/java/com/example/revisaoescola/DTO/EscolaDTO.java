package com.example.revisaoescola.DTO;

import com.example.revisaoescola.model.entities.Curso;
import com.example.revisaoescola.model.entities.Endereco;
import com.example.revisaoescola.model.entities.Professor;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class EscolaDTO {

    String nome;

    Endereco endereco;

    @Email
    String email;

    List<Professor> listaDeProfessores;

    List<Curso> listaDeCursos;

}
