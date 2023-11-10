package com.example.lemsecurity.domain.local;
import com.example.lemsecurity.domain.colaborador.Colaborador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLocal(
        @NotNull
        int cod,
        @NotBlank
        String nome,
        String descricao,
        @NotNull
        Colaborador responsavel) {


}
