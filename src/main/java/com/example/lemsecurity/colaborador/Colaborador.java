package com.example.lemsecurity.colaborador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "colaboradores")
@Entity(name = "Colaborador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int matricula;
    private String nome;
    private LocalDate dataAdmissao;
    private Boolean ativo;


    public Colaborador(DadosCadastroColaborador dados) {
        this.nome = dados.nome();
        this.matricula = dados.matricula();
        this.dataAdmissao = dados.dataAdmissao();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoColaborador dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.dataAdmissao = dados.dataAdmissao() != null ? dados.dataAdmissao() : this.dataAdmissao;
    }

    public void deletar() {
        this.ativo = false;
    }
}
