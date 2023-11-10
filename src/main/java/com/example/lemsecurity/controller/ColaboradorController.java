package com.example.lemsecurity.controller;

import com.example.lemsecurity.domain.colaborador.*;
import com.example.lemsecurity.repository.ColaboradorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody DadosCadastroColaborador dados, UriComponentsBuilder uriComponentsBuilder) {
        Colaborador colaborador = new Colaborador(dados);
        repository.save(colaborador);

        var uri = uriComponentsBuilder.path("/colaborador/{id}").buildAndExpand(colaborador.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoColaborador(colaborador));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemColaborador>> listarColaboradores(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemColaborador::new);
        return ResponseEntity.ok(page);
    }


    @GetMapping("/colaborador/{id}")
    public ResponseEntity<DadosDetalhamentoColaborador> listaUmColaboradorPorId(@PathVariable(value = "id") Long id) {
        Colaborador colaborador = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoColaborador(colaborador));
    }


    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoColaborador> atualizar(@RequestBody @Valid DadosAtualizacaoColaborador dados) {
        var colaborador = repository.getReferenceById(dados.id());
        colaborador.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoColaborador(colaborador));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable(value = "id") Long id) {
        var colaborador = repository.getReferenceById(id);
        colaborador.deletar();
        return ResponseEntity.noContent().build();
    }


}
