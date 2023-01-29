package com.restapi.attornatus.services;

import com.restapi.attornatus.dtos.PessoaDTO;
import com.restapi.attornatus.entities.Pessoa;
import com.restapi.attornatus.exceptions.BusinessException;
import com.restapi.attornatus.mappers.DozerMapper;
import com.restapi.attornatus.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

        if(optionalPessoa.isPresent()){
            throw new BusinessException("Pessoa já cadastrada.");
        }

        PessoaDTO dto = DozerMapper.parseObject(optionalPessoa.get(), PessoaDTO.class);
        dto.add(linkTo(methodOn(PessoaService.class).findById(dto.getKey())).withSelfRel());

        return dto;
    }

    //editar pessoa

    //consultar uma pessoa
    public PessoaDTO findById(Long id){
        var entity = pessoaRepository.findById(id);
        //.orElseThrow(() -> new NoSuchElementException("No records for this id."));

        PessoaDTO dto = DozerMapper.parseObject(entity, PessoaDTO.class);
        dto.add(linkTo(methodOn(PessoaService.class).findById(id)).withSelfRel());

        return dto;
    }

    //listar pessoas
}
