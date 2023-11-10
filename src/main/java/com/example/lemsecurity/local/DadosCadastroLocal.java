package com.example.lemsecurity.local;
import com.example.lemsecurity.colaborador.Colaborador;
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
