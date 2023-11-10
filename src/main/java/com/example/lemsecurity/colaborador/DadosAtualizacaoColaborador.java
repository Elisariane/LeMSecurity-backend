package com.example.lemsecurity.colaborador;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DadosAtualizacaoColaborador(
        @NotNull
        Long id,
        String nome,
        LocalDate dataAdmissao
) {
}
