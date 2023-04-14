package com.example.revisaoescola.DTO;

import com.example.revisaoescola.model.entities.Endereco;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class AlunoDTO {

    String nome;

    @Email
    String email;

    String telefone;

    Endereco endereco;
}
