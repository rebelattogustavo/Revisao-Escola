package com.example.revisaoescola.model.service;

import com.example.revisaoescola.model.entities.Endereco;
import com.example.revisaoescola.model.entities.Escola;
import com.example.revisaoescola.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    public <S extends Escola> S save(S entity) {
        return escolaRepository.save(entity);
    }

    public Optional<Escola> findById(Long aLong) {
        return escolaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return escolaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        escolaRepository.deleteById(aLong);
    }

}
