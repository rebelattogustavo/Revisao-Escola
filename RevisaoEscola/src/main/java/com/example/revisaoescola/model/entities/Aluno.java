package com.example.revisaoescola.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;


    @Column(name = "nome")
    String nome;

    @Email
    @Column(name = "email")
    String email;

    @Column(name = "telefone")
    String telefone;

    @OneToOne
    @JoinColumn(name = "endereco")
    Endereco endereco;

}
