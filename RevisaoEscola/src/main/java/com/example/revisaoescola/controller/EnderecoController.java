package com.example.revisaoescola.controller;

import com.example.revisaoescola.DTO.EnderecoDTO;
import com.example.revisaoescola.model.entities.Endereco;
import com.example.revisaoescola.model.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping()
    public ResponseEntity<Object> listarEnderecos() {
        return ResponseEntity.ok().body(enderecoService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Object> cadastrarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        try{
            Endereco endereco = new Endereco();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            return ResponseEntity.ok().body(enderecoService.save(endereco));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Endereço não cadastrado! Message: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEndereco(@PathVariable Long id, @RequestBody @Valid EnderecoDTO enderecoDTO) {
        try{
            Endereco endereco = enderecoService.findById(id).get();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            return ResponseEntity.ok().body(enderecoService.save(endereco));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Endereço não atualizado! Message: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarEndereco(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(enderecoService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Endereço não encontrado! Message: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarEndereco(@PathVariable Long id) {
        try{
            enderecoService.deleteById(id);
            return ResponseEntity.ok().body("Endereço deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Endereço não deletado! Message: " + e.getMessage());
        }
    }

}
