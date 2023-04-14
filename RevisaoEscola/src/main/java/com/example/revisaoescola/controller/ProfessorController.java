package com.example.revisaoescola.controller;

import com.example.revisaoescola.DTO.ProfessorDTO;
import com.example.revisaoescola.model.entities.Professor;
import com.example.revisaoescola.model.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping()
    public ResponseEntity<Object> listarProfessores() {
        return ResponseEntity.ok().body(professorService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Object> cadastrarProfessor(@RequestBody @Valid ProfessorDTO professorDTO) {
        try{
            Professor professor = new Professor();
            BeanUtils.copyProperties(professorDTO, professor);
            return ResponseEntity.ok().body(professorService.save(professor));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Professor não cadastrado! Message: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProfessor(@PathVariable Long id, @RequestBody @Valid ProfessorDTO professorDTO) {
        try{
            Professor professor = professorService.findById(id).get();
            BeanUtils.copyProperties(professorDTO, professor);
            return ResponseEntity.ok().body(professorService.save(professor));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Professor não atualizado! Message: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProfessor(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(professorService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Professor não encontrado! Message: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProfessor(@PathVariable Long id) {
        try{
            professorService.deleteById(id);
            return ResponseEntity.ok().body("Professor deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Professor não deletado! Message: " + e.getMessage());
        }
    }

}
