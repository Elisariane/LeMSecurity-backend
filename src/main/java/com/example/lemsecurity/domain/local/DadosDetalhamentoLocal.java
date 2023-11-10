package com.example.lemsecurity.domain.local;

public record DadosDetalhamentoLocal(
        Long id,
        String nome,
        String descricao,
        String responsavel
) {

    public DadosDetalhamentoLocal(Local local) {
        this(local.getId(), local.getNome(), local.getDescricao(), local.getResponsavel().getNome());
    }
}
