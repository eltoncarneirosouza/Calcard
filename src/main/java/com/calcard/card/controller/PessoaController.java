package com.calcard.card.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcard.card.dto.SimulaScoreDTO;
import com.calcard.card.forms.PessoaForm;
import com.calcard.card.model.Pessoa;
import com.calcard.card.repositoty.PessoaRepository;
import com.calcard.card.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repositorio;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> lista() {
	List<Pessoa> lista = repositorio.findAll();
	return lista;
    }
    
    @GetMapping(value = "/simulacao")
    public List<SimulaScoreDTO> simulacao() {
	List<Pessoa> lista = repositorio.findAll();
	List<SimulaScoreDTO> simulacao = new ArrayList<>();
	lista.forEach(dados->{
	    Pessoa pessoa = dados;
	    SimulaScoreDTO score = new SimulaScoreDTO(pessoa);
	    simulacao.add(score);
	});
	return simulacao;
    }
    
    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody PessoaForm formulario) {
	Pessoa pessoa = formulario.converter();
	try {
	    pessoaService.salvar(pessoa);
	    return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<Pessoa>(pessoa, HttpStatus.BAD_REQUEST);
	}

    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Pessoa> buscaPessoa(@PathVariable(value = "cpf") String cpf) {
	Optional<Pessoa> optional = repositorio.findByCpf(cpf);
	if (optional.isPresent()) {
	    Pessoa pessoa = optional.get();
	    return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    }

}
