package com.calcard.card.repositoty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcard.card.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    @Query(value = "select p from Pessoa p where p.cpf = :cpf")
    Optional<Pessoa> findByCpf(String cpf);

}
