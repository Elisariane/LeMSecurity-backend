package com.example.lemsecurity.domain.colaborador;

import java.time.LocalDate;

public record DadosDetalhamentoColaborador(
        Long id,
        String nome,
        int matricula,
        LocalDate dataAdmissao
) {

    public DadosDetalhamentoColaborador(Colaborador colaborador) {
        this(colaborador.getId(), colaborador.getNome(), colaborador.getMatricula(), colaborador.getDataAdmissao());
    }
}
