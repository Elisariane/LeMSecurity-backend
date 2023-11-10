package com.example.lemsecurity.controller;

import com.example.lemsecurity.colaborador.Colaborador;
import com.example.lemsecurity.colaborador.DadosAtualizacaoColaborador;
import com.example.lemsecurity.colaborador.DadosCadastroColaborador;
import com.example.lemsecurity.colaborador.DadosListagemColaborador;
import com.example.lemsecurity.repository.ColaboradorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@Valid @RequestBody DadosCadastroColaborador dados) {
        try {
            Colaborador colaborador = new Colaborador(dados);
            repository.save(colaborador);
            return ResponseEntity.status(HttpStatus.CREATED).body("Colaborador cadastrado com sucesso!");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar colaborador: " + e.getMessage());
        }
    }

    @GetMapping
    public Page<DadosListagemColaborador> listarColaboradores(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemColaborador::new);
    }


    @GetMapping("/colaborador/{id}")
    public ResponseEntity<Colaborador> listaUmColaboradorPorId(@PathVariable(value = "id") Long id) {
        Optional<Colaborador> colaborador = repository.findById(id);
        return colaborador.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoColaborador dados) {
        var colaborador = repository.getReferenceById(dados.id());
        colaborador.atualizarInformacoes(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable(value = "id") Long id) {
        var colaborador = repository.getReferenceById(id);
        colaborador.deletar();
    }



}
