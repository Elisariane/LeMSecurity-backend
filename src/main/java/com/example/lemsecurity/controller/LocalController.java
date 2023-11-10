package com.example.lemsecurity.controller;

import com.example.lemsecurity.domain.local.DadosCadastroLocal;
import com.example.lemsecurity.domain.local.Local;
import com.example.lemsecurity.repository.LocalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locais")
public class LocalController {

    @Autowired
    private LocalRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody DadosCadastroLocal dados) {
        repository.save(new Local(dados));
    }


}
