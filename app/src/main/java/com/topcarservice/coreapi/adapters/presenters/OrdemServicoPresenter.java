package com.topcarservice.coreapi.adapters.presenters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.OrdemServicoUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Ordem de Serviço", description = "Gerenciamento de ordens de serviço")
@AllArgsConstructor
@RestController
@RequestMapping("/public/ordem-servicos")
public class OrdemServicoPresenter {
	
	OrdemServicoUseCase ordemServicoUseCase;		
	
	OrdemServicoMapper ordemServicoMapper;		
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoRetornoDTO> buscar(@PathVariable("id") Long codigo) {	
		
		try {
			OrdemServico ordemServico = ordemServicoUseCase.carregar(codigo);	
			
			OrdemServicoRetornoDTO ordemservicoResponse = ordemServicoMapper.map(ordemServico);
			
			return ResponseEntity.ok().body(ordemservicoResponse);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		}	
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServicoRetornoDTO>> listar() {	
		
		List<OrdemServico> ordemsServico = ordemServicoUseCase.listar();
		
		List<OrdemServicoRetornoDTO> ordemsServicoRetorno  = ordemServicoMapper.map(ordemsServico);
		
		return ResponseEntity.ok().body(ordemsServicoRetorno);
	}

}
