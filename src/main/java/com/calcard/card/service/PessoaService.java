package com.calcard.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcard.card.model.Pessoa;
import com.calcard.card.repositoty.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvar(Pessoa pessoa) {
	pessoaRepository.save(pessoa);
    }

}
