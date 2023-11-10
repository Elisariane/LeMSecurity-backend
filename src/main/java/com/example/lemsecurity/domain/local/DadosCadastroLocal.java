package com.example.lemsecurity.domain.local;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLocal(
        @NotNull
        int cod,
        @NotBlank
        String nome,
        String descricao,
        Long responsavelId
) {


}
