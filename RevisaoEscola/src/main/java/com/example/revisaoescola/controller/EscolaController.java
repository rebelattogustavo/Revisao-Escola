package com.example.revisaoescola.controller;

import com.example.revisaoescola.DTO.EscolaDTO;
import com.example.revisaoescola.model.entities.Escola;
import com.example.revisaoescola.model.service.EscolaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/escola")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @GetMapping()
    public ResponseEntity<Object> listarEscolas() {
        return ResponseEntity.ok().body(escolaService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Object> cadastrarEscola(@RequestBody @Validated @Valid EscolaDTO escolaDTO) {
        try{
            Escola escola = new Escola();
            BeanUtils.copyProperties(escolaDTO, escola);
            System.out.println(escola);
            return ResponseEntity.ok().body(escolaService.save(escola));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Escola não cadastrada! Message: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEscola(@PathVariable Long id, @RequestBody @Valid EscolaDTO escolaDTO) {
        try{
            Escola escola = escolaService.findById(id).get();
            BeanUtils.copyProperties(escolaDTO, escola);
            return ResponseEntity.ok().body(escolaService.save(escola));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Escola não atualizada! Message: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarEscola(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(escolaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Escola não encontrada! Message: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarEscola(@PathVariable Long id) {
        try{
            escolaService.deleteById(id);
            return ResponseEntity.ok().body("Escola deletada com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Escola não deletada! Message: " + e.getMessage());
        }
    }

}
