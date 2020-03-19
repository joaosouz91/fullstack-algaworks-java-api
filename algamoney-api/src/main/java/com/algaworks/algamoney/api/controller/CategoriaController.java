package com.algaworks.algamoney.api.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algamoney.api.event.CreatedResourceEvent;
import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.	api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
//	@GetMapping
//	public ResponseEntity<?> listar(){
//		List<Categoria> categorias = categoriaRepository.findAll();
//		return !categorias.isEmpty()? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
//	}
	
	//@CrossOrigin(maxAge = 10, origins = "http://localhost:3000")
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") // alem da permissao do usuario tem a permissao da aplicacao tbm (scope)
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> categoriaList = categoriaRepository.findAll();
		return !categoriaList.isEmpty() ? ResponseEntity.ok(categoriaList) : ResponseEntity.noContent().build();
	}
	
//	@PostMapping
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public void criar(@RequestBody Categoria entity, HttpServletResponse response) {
//		Categoria categoria = categoriaRepository.save(entity);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
//			.buildAndExpand(categoria.getCodigo()).toUri();
//		response.setHeader("Location", uri.toASCIIString());
//	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		eventPublisher.publishEvent(new CreatedResourceEvent(this, response, categoriaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public ResponseEntity<Categoria> findById(@PathVariable("codigo") Long id) {
		Categoria categoria = categoriaRepository.findOne(id);
		return categoria != null? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
	

}
