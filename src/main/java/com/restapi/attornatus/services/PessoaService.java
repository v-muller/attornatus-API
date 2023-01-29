package com.restapi.attornatus.services;

import com.restapi.attornatus.dtos.PessoaDTO;
import com.restapi.attornatus.entities.Pessoa;
import com.restapi.attornatus.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    //criar pessoa
    public PessoaDTO createPessoa(PessoaDTO pessoaDTO){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaDTO.getKey());

    }

    //editar pessoa

    //consultar uma pessoa

    //listar pessoas
}
