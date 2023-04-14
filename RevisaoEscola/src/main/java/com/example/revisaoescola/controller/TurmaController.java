package com.example.revisaoescola.controller;

import com.example.revisaoescola.DTO.TurmaDTO;
import com.example.revisaoescola.model.entities.Turma;
import com.example.revisaoescola.model.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping()
    public ResponseEntity<Object> listarTurmas() {
        return ResponseEntity.ok().body(turmaService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Object> cadastrarTurma(@RequestBody @Valid TurmaDTO turmaDTO) {
        try{
            Turma turma = new Turma();
            BeanUtils.copyProperties(turmaDTO, turma);
            return ResponseEntity.ok().body(turmaService.save(turma));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Turma não cadastrada! Message: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarTurma(@PathVariable Long id, @RequestBody @Valid TurmaDTO turmaDTO) {
        try{
            Turma turma = turmaService.findById(id).get();
            BeanUtils.copyProperties(turmaDTO, turma);
            return ResponseEntity.ok().body(turmaService.save(turma));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Turma não atualizada! Message: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarTurma(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(turmaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Turma não encontrada! Message: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarTurma(@PathVariable Long id) {
        try{
            turmaService.deleteById(id);
            return ResponseEntity.ok().body("Turma deletada com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Turma não deletada! Message: " + e.getMessage());
        }
    }

}
