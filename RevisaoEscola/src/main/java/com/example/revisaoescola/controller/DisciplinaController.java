package com.example.revisaoescola.controller;

import com.example.revisaoescola.DTO.DisciplinaDTO;
import com.example.revisaoescola.model.entities.Disciplina;
import com.example.revisaoescola.model.service.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping()
    public ResponseEntity<Object> listarDisciplinas() {
        return ResponseEntity.ok().body(disciplinaService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Object> cadastrarDisciplina(@RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        try{
            Disciplina disciplina = new Disciplina();
            BeanUtils.copyProperties(disciplinaDTO, disciplina);
            return ResponseEntity.ok().body(disciplinaService.save(disciplina));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Disciplina não cadastrada! Message: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarDisciplina(@PathVariable Long id, @RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        try{
            Disciplina disciplina = disciplinaService.findById(id).get();
            BeanUtils.copyProperties(disciplinaDTO, disciplina);
            return ResponseEntity.ok().body(disciplinaService.save(disciplina));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Disciplina não atualizada! Message: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarDisciplina(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(disciplinaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Disciplina não encontrada! Message: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarDisciplina(@PathVariable Long id) {
        try{
            disciplinaService.deleteById(id);
            return ResponseEntity.ok().body("Disciplina deletada com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Disciplina não deletada! Message: " + e.getMessage());
        }
    }

}
