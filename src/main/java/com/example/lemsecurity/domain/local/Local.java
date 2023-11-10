package com.example.lemsecurity.domain.local;

import com.example.lemsecurity.domain.colaborador.Colaborador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "locais")
@Entity(name = "Local")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cod;
    private String nome;
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "responsavel_id", referencedColumnName = "id")
    private Colaborador responsavel;

    private Boolean ativo;


    public Local(DadosCadastroLocal dados, Colaborador responsavel){
        this.cod = dados.cod();
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.responsavel = responsavel;
        this.ativo = true;
    }


    public void atualizarInformacoes(DadosAtualizacaoLocal dados, Colaborador responsavel) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.descricao = dados.nome() != null ? dados.nome() : this.nome;
        this.responsavel = dados.responsavelId() != null ? responsavel : this.responsavel;
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
    }

    public void deletar() {
        this.ativo = false;
    }

}
