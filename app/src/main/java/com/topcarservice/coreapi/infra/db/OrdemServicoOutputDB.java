package com.topcarservice.coreapi.infra.db;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoOutputPort;
import com.topcarservice.coreapi.infra.db.mappers.OrdemServicoDBMapper;
import com.topcarservice.coreapi.infra.db.repositories.OrdemServicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrdemServicoOutputDB implements OrdemServicoOutputPort {
	
	private final OrdemServicoRepository ordemServicoRepository;
	
	private final OrdemServicoDBMapper ordemServicoDBMapper;	

	@Override
	public Optional<OrdemServico> findById(Long codigo) {		
		
		return ordemServicoRepository.findById(codigo)
				.map(ordemServicoDBMapper::mapTo);
	}

	@Override
	public List<OrdemServico> findAll() {		
		return ordemServicoRepository.findAll()
				.stream()
				.map(ordemServicoDBMapper::mapTo)
				.toList();
	}

}

