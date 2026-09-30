package com.topcarservice.coreapi.adapters.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.OrdemServicoUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Ordem de Serviço", description = "Gerenciamento de ordens de serviço")
@AllArgsConstructor
@RestController
@RequestMapping("/admin/ordem-servicos")
public class OrdemServicoController {
	
	OrdemServicoUseCase ordemServicoUseCase;		
	
	OrdemServicoMapper ordemServicoMapper;	
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Validated OrdemServicoDTO ordemServicoDto) {			
		
		try {			
			
			OrdemServico ordemServico = new OrdemServico();						
			
			var ordemServicoSalva =  ordemServicoUseCase.cadastrar(ordemServico);
			return ResponseEntity.created(URI.create("/admin/ordem-servicos/" + ordemServicoSalva.getCodigo())).build();			
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		}	
	}	
	
	
	
	@PutMapping("/{id}/aprovacao")
	public ResponseEntity<OrdemServicoRetornoDTO> enviarAprovacao(@PathVariable("id") Long codigo) {			
		
		try {
			OrdemServico ordemServico = ordemServicoUseCase.carregar(codigo);	
			
			//ordemServicoUseCase.enviarAprovacao(ordemServico); TODO TEST ALTERAR
			
			OrdemServicoRetornoDTO ordemservicoResponse = ordemServicoMapper.map(ordemServico);
			
			return ResponseEntity.ok().body(ordemservicoResponse);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		} catch (IllegalStateException e) {			
			return ResponseEntity.badRequest().build();
		}	
	}	

}
