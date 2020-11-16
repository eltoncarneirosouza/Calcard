package com.calcard.card.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcard.card.dto.SimulaScoreDTO;
import com.calcard.card.model.Pessoa;
import com.calcard.card.repositoty.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvar(Pessoa pessoa) {
	pessoaRepository.save(pessoa);
    }

    public List<SimulaScoreDTO> simulacao(List<Pessoa> lista) {
	List<SimulaScoreDTO> simulacao = new ArrayList<>();
	lista.forEach(dados -> {
	    Pessoa pessoa = dados;
	    SimulaScoreDTO score = new SimulaScoreDTO(pessoa);
	    simulacao.add(score);
	});
	return simulacao;
    }

}
