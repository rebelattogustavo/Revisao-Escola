package com.example.revisaoescola.DTO;

import com.example.revisaoescola.model.entities.Aluno;
import com.example.revisaoescola.model.entities.Escola;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class TurmaDTO {

    String nome;

    Escola escola;

    List<Aluno> listaDeAlunos;

}
