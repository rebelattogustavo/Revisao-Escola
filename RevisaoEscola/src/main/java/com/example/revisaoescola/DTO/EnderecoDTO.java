package com.example.revisaoescola.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class EnderecoDTO {

    String rua;

    @Positive
    Integer numero;

    String cidade;

    String estado;

    String bairro;

    @Min(value = 10000000L)
    @Max(value = 99999999L)
    Long cep;

}
