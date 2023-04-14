package com.example.revisaoescola.controller;

import com.example.revisaoescola.DTO.AlunoDTO;
import com.example.revisaoescola.model.entities.Aluno;
import com.example.revisaoescola.model.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<Object> listarAlunos() {
        return ResponseEntity.ok().body(alunoService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Object> cadastrarAluno(@RequestBody @Valid AlunoDTO alunoDTO) {
        try{
            Aluno aluno = new Aluno();
            BeanUtils.copyProperties(alunoDTO, aluno);
            return ResponseEntity.ok().body(alunoService.save(aluno));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Aluno não cadastrado! Message: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAluno(@PathVariable Long id, @RequestBody @Valid AlunoDTO alunoDTO) {
        try{
            Aluno aluno = alunoService.findById(id).get();
            BeanUtils.copyProperties(alunoDTO, aluno);
            return ResponseEntity.ok().body(alunoService.save(aluno));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Aluno não atualizado! Message: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarAluno(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(alunoService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Aluno não encontrado! Message: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable Long id) {
        try{
            alunoService.deleteById(id);
            return ResponseEntity.ok().body("Aluno deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Aluno não deletado! Message: " + e.getMessage());
        }
    }



}
