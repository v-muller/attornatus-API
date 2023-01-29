package com.restapi.attornatus.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restapi.attornatus.entities.Endereco;
import org.dozer.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PessoaDTO extends RepresentationModel<PessoaDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    private String nome;

    private Date dataNascimento;

    private List<Endereco> enderecos;

    public PessoaDTO(){}

    public PessoaDTO(Long key, String nome, Date dataNascimento, List<Endereco> enderecos) {
        this.key = key;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
