package com.topcarservice.coreapi.infra.db;

import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoInputPort;
import com.topcarservice.coreapi.infra.db.mappers.OrdemServicoDBMapper;
import com.topcarservice.coreapi.infra.db.repositories.OrdemServicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrdemServicoInputDB implements OrdemServicoInputPort {
	
	private final OrdemServicoRepository ordemServicoRepository;
	
	private final OrdemServicoDBMapper ordemServicoDBMapper;

	@Override
	public OrdemServico save(OrdemServico ordemServico) {
		
		var ordemServicoDB = ordemServicoDBMapper.map(ordemServico);		
		var ordemServicoDBSaved = ordemServicoRepository.save(ordemServicoDB);
		
		return ordemServicoDBMapper.mapTo(ordemServicoDBSaved);
		
	}

	@Override
	public void delete(OrdemServico ordemServico) {
		ordemServicoRepository.delete(ordemServicoDBMapper.map(ordemServico));		
	}

}
