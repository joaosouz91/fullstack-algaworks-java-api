package com.algaworks.algamoney.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa findOne(Long codigo) {
		Pessoa pessoa = pessoaRepository.findOne(codigo);
		if(pessoa == null) throw new EmptyResultDataAccessException(1);
		return pessoa;
	}
	
	public Pessoa create(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa updateAll(Long codigo, Pessoa pessoa) {
		Pessoa savedPessoa = this.findOne(codigo);
		BeanUtils.copyProperties(pessoa, savedPessoa, "codigo");
		return pessoaRepository.save(savedPessoa);
	}
	
	public Pessoa updateAtivo(Long codigo, Boolean ativo) {
		Pessoa savedPessoa = this.findOne(codigo);
		savedPessoa.setAtivo(ativo);
		return pessoaRepository.save(savedPessoa);
	}
	
	public Pessoa updatePartial() {
		return new Pessoa();
	}

	public void delete(Long codigo) {
		pessoaRepository.delete(codigo);
	}
	
	
}
