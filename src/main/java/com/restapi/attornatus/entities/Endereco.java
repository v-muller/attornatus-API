package com.restapi.attornatus.entities;

import com.restapi.attornatus.enums.EnderecoPrincipal;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "enderecos")
public class Endereco implements Serializable {
    private static final long seriaLVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "logradouro", length = 80)
    private String logradouro;

    @Column(nullable = false, name = "cep", length = 9)
    private String cep;

    @Column(nullable = false, name = "numero", length = 9)
    private String numero;

    @Column(nullable = false, name = "cidade", length = 28)
    private String cidade;

    @Column(nullable = false, name = "endereco_principal")
    private Integer principal;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco(){}

    public Endereco(String logradouro, String cep, String numero, String cidade, Integer principal, Pessoa pessoa) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.principal = principal;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public EnderecoPrincipal getPrincipal() {
        return EnderecoPrincipal.valueOf(this.principal);
    }

    public void setPrincipal(EnderecoPrincipal principal) {
        if (principal != null) {
            this.principal = principal.getCode();
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
