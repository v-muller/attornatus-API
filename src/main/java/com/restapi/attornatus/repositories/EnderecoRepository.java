package com.restapi.attornatus.repositories;

import com.restapi.attornatus.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT endereco FROM Endereco endereco WHERE endereco.pessoa.id = :pessoaId ")
    List<Endereco> findFichaByAlunoId(Long pessoaId);
}
