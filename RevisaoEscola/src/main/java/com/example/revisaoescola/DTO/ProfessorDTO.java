package com.example.revisaoescola.DTO;

import com.example.revisaoescola.model.entities.Disciplina;
import com.example.revisaoescola.model.entities.Endereco;
import com.example.revisaoescola.model.entities.Escola;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class ProfessorDTO {

    String nome;

    @Email
    String email;

    String telefone;

    Escola escola;

    List<Disciplina> listaDeDisciplinas;

    Endereco endereco;

}
