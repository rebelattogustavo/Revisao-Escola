package com.example.revisaoescola.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_endereco")
@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "rua")
    String rua;

    @Column(name = "numero", length = 11)
    @Positive
    Integer numero;

    @Column(name = "cidade")
    String cidade;

    @Column(name = "estado")
    String estado;

    @Column(name = "bairro")
    String bairro;

    @Column(name = "cep")
    Long cep;


}
