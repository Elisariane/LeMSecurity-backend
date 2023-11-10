package com.example.lemsecurity.controller;

import com.example.lemsecurity.domain.local.DadosAtualizacaoLocal;
import com.example.lemsecurity.domain.local.DadosCadastroLocal;
import com.example.lemsecurity.domain.local.DadosDetalhamentoLocal;
import com.example.lemsecurity.domain.local.Local;
import com.example.lemsecurity.repository.ColaboradorRepository;
import com.example.lemsecurity.repository.LocalRepository;
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
@RequestMapping("locais")
public class LocalController {

    @Autowired
    private LocalRepository repository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLocal> cadastrar(@Valid @RequestBody DadosCadastroLocal dados, UriComponentsBuilder uriComponentsBuilder) {
        var responsavel = colaboradorRepository.findById(dados.responsavelId()).orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
        var local = new Local(dados, responsavel);
        repository.save(local);

        var uri = uriComponentsBuilder.path("/local/{id}").buildAndExpand(local.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLocal(local));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoLocal>> listaTodos(@PageableDefault(size = 10, sort = {"cod"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosDetalhamentoLocal::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/local/{id}")
    public ResponseEntity<DadosDetalhamentoLocal> listaLocalPorId(@PathVariable(value = "id") Long id) {
        Local local = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLocal(local));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLocal> atualizar(@RequestBody @Valid DadosAtualizacaoLocal dados) {
        var local = repository.getReferenceById(dados.id());
        var responsavel = colaboradorRepository.findById(dados.responsavelId()).orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
        local.atualizarInformacoes(dados, responsavel);
        return ResponseEntity.ok(new DadosDetalhamentoLocal(local));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable(value = "id") Long id) {
        var local = repository.getReferenceById(id);
        local.deletar();
        return ResponseEntity.noContent().build();
    }

}
