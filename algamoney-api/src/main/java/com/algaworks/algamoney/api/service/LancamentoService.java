package com.algaworks.algamoney.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.model.dto.LancamentoDTO;
import com.algaworks.algamoney.api.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public List<Lancamento> findAll() {
		List<Lancamento> lancamentoList =  lancamentoRepository.findAll();
		return lancamentoList;
		
//		List<LancamentoDTO> lancamentoDTOList = new ArrayList<LancamentoDTO>();
//		
//		for (Lancamento lancamento : lancamentoList) {
//			LancamentoDTO dto = new LancamentoDTO();
//			BeanUtils.copyProperties(lancamento, dto, "categoria", "pessoa");
//			dto.setCodigo_categoria(lancamento.getCategoria().getCodigo());
//			dto.setCodigo_pessoa(lancamento.getPessoa().getCodigo());
//			lancamentoDTOList.add(dto);
//		}
//		return null;
	}
	
}
