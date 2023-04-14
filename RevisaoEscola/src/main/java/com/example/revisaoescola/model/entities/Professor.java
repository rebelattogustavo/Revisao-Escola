package com.example.revisaoescola.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_professor")
@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nome")
    String nome;

    @Column(name = "email")
    @Email
    String email;

    @Column(name = "telefone")
    String telefone;

    @ManyToOne
    @JoinColumn(name = "escola")
    @JsonIgnore
    Escola escola;

    @Column(name = "lista_de_disciplinas")
    @ManyToMany(mappedBy = "listaDeProfessores")
    List<Disciplina> listaDeDisciplinas;

    @JoinColumn(name = "endereco")
    @OneToOne
    Endereco endereco;

}
