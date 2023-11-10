package com.example.lemsecurity.colaborador;

import java.time.LocalDate;

public record DadosListagemColaborador(
        Long id,
        String nome,
        int matricula,
        LocalDate dataAdmissao
) {

    public DadosListagemColaborador(Colaborador colaborador) {
        this(colaborador.getId(), colaborador.getNome(), colaborador.getMatricula(), colaborador.getDataAdmissao());
    }

}
