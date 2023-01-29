package com.restapi.attornatus.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restapi.attornatus.entities.Pessoa;
import org.dozer.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class EnderecoDTO extends RepresentationModel<EnderecoDTO> implements Serializable {

    private static final long seriaLVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

    private Pessoa pessoa;

    public EnderecoDTO(){}

    public EnderecoDTO(String logradouro, String cep, String numero, String cidade, Pessoa pessoa) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoa = pessoa;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
