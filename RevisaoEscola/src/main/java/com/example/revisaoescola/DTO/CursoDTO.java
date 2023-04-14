package com.example.revisaoescola.DTO;

import com.example.revisaoescola.model.entities.Disciplina;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class CursoDTO {

    String nome;

    List<Disciplina> listaDeDisciplinas;
}
