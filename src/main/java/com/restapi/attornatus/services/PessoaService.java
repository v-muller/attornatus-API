package com.restapi.attornatus.services;

import com.restapi.attornatus.dtos.PessoaDTO;
import com.restapi.attornatus.entities.Pessoa;
import com.restapi.attornatus.exceptions.BusinessException;
import com.restapi.attornatus.exceptions.EntityNotFoundException;
import com.restapi.attornatus.mappers.DozerMapper;
import com.restapi.attornatus.repositories.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
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

        Pessoa entity = DozerMapper.parseObject(pessoaDTO, Pessoa.class);
        pessoaDTO.add(linkTo(methodOn(PessoaService.class).findById(pessoaDTO.getKey())).withSelfRel());

        pessoaRepository.save(entity);

        return DozerMapper.parseObject(entity, PessoaDTO.class);
    }

    //editar pessoa
    public PessoaDTO updatePessoa(PessoaDTO pessoaDTO){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaDTO.getKey());

        if(optionalPessoa.isEmpty()){
            throw new BusinessException("Pessoa não encontrada.");
        }
        Pessoa entity = DozerMapper.parseObject(pessoaDTO, Pessoa.class);
        entity.setId(pessoaDTO.getKey());
        pessoaRepository.save(entity);

        PessoaDTO dto = DozerMapper.parseObject(entity, PessoaDTO.class);
        dto.add(linkTo(methodOn(PessoaService.class).findById(dto.getKey())).withSelfRel());

        return dto;
    }

    //consultar uma pessoa
    public PessoaDTO findById(Long id){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);

        if (optionalPessoa.isEmpty()) {
            throw new EntityNotFoundException("Aluno não encontrado.");
        }

        PessoaDTO dto = DozerMapper.parseObject(optionalPessoa.get(), PessoaDTO.class);
        dto.add(linkTo(methodOn(PessoaService.class).findById(id)).withSelfRel());

        return dto;
    }

    //listar pessoas
    public Page<PessoaDTO> findAll(){
        int page = 0;
        int size = 10;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

        return new PageImpl<>(
                DozerMapper.parseListObjects(pessoaRepository.findAll(), PessoaDTO.class),
                pageRequest, size);
    }

    public void delete(Long id){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);

        if (optionalPessoa.isEmpty()) {
            throw new EntityNotFoundException("Aluno não encontrado.");
        }

        pessoaRepository.delete(optionalPessoa.get());
    }

    //criar endereço

    //listar endereços

    //poder informar qual o endereço principal
}
