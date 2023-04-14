package com.example.revisaoescola.controller;

import com.example.revisaoescola.DTO.CursoDTO;
import com.example.revisaoescola.model.entities.Curso;
import com.example.revisaoescola.model.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public ResponseEntity<Object> listarCursos() {
        return ResponseEntity.ok().body(cursoService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Object> cadastrarCurso(@RequestBody @Valid CursoDTO cursoDTO) {
        try{
            Curso curso = new Curso();
            BeanUtils.copyProperties(cursoDTO, curso);
            return ResponseEntity.ok().body(cursoService.save(curso));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Curso não cadastrado! Message: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCurso(@PathVariable Long id, @RequestBody @Valid CursoDTO cursoDTO) {
        try{
            Curso curso = cursoService.findById(id).get();
            BeanUtils.copyProperties(cursoDTO, curso);
            return ResponseEntity.ok().body(cursoService.save(curso));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Curso não atualizado! Message: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCurso(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(cursoService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Curso não encontrado! Message: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCurso(@PathVariable Long id) {
        try{
            cursoService.deleteById(id);
            return ResponseEntity.ok().body("Curso deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Curso não deletado! Message: " + e.getMessage());
        }
    }


}
