package com.example.revisaoescola.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_escola")
@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nome")
    String nome;

    @OneToOne()
    @JoinColumn(name = "endereco")
    Endereco endereco;

    @Column(name = "email")
    @Email
    String email;

    @OneToMany(mappedBy = "escola")
    List<Professor> listaDeProfessores;

    @ManyToMany()
    @JoinTable(name = "tb_escola_curso",
            joinColumns = @JoinColumn(name = "escola"),
            inverseJoinColumns = @JoinColumn(name = "curso"))
    List<Curso> listaDeCursos;

}
