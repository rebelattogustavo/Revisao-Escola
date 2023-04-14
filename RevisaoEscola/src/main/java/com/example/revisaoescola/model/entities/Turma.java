package com.example.revisaoescola.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_turma")
@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nome")
    String nome;

    @ManyToOne
    @JoinColumn(name = "escola")
    Escola escola;

    @OneToMany()
    @JoinColumn(name = "id_turma")
    List<Aluno> listaDeAlunos;

}
