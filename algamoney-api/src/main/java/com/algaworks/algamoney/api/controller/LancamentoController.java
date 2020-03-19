package com.algaworks.algamoney.api.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoney.api.event.CreatedResourceEvent;
import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.repository.filter.LancamentoFilter;
import com.algaworks.algamoney.api.repository.projection.ResumoLancamento;
import com.algaworks.algamoney.api.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired 
	private ApplicationEventPublisher eventPublisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public ResponseEntity<Page<Lancamento>> find(LancamentoFilter lancamentoFilter, Pageable pageable) {
		Page<Lancamento> lancamentos = lancamentoService.filter(lancamentoFilter, pageable);
		return lancamentos.getNumberOfElements() > 0 ? ResponseEntity.ok(lancamentos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping(params = "resume")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public ResponseEntity<Page<ResumoLancamento>> resume(LancamentoFilter lancamentoFilter, Pageable pageable) {
		Page<ResumoLancamento> lancamentos = lancamentoService.resume(lancamentoFilter, pageable);
		return lancamentos.getNumberOfElements() > 0 ? ResponseEntity.ok(lancamentos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public ResponseEntity<Lancamento> findById(@PathVariable("codigo") Long codigo) {
		Lancamento lancamento = lancamentoService.findById(codigo);
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Lancamento> create(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
		Lancamento savedLancamento = lancamentoService.create(lancamento);
		eventPublisher.publishEvent(new CreatedResourceEvent(this, response, savedLancamento.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Lancamento> delete(@PathVariable("codigo") Long codigo) {
		lancamentoService.delete(codigo);
		return ResponseEntity.ok().build();
	}
	

}
