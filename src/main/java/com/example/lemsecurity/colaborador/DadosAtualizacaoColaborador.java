package com.example.lemsecurity.colaborador;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoColaborador(
        @NotNull
        Long id,
        String nome,
        LocalDate dataAdmissao
) {
}
