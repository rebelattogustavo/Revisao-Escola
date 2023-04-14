package com.example.revisaoescola.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_curso")
@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    Long id;

    @Column(name = "nome_curso")
    String nome;

    @ManyToMany
    @JoinTable(name = "tb_curso_disciplina",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
    List<Disciplina> listaDeDisciplinas;


}
