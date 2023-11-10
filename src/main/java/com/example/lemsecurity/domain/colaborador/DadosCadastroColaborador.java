package com.example.lemsecurity.domain.colaborador;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DadosCadastroColaborador(
        @NotNull(message = "Matrícula é obrigatório")
        int matricula,
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "yyyy-MM-dd")
        @NotNull(message = "Nome é obrigatório")
        LocalDate dataAdmissao
) {
}
