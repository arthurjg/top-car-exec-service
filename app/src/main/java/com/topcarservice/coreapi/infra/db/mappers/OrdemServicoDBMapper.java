package com.topcarservice.coreapi.infra.db.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.infra.db.entities.OrdemServicoDBEntity;

@Component
public class OrdemServicoDBMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public OrdemServicoDBEntity map(OrdemServico ordemServico) {		
		return OrdemServicoDBEntity.builder()
				.status(ordemServico.getStatus().getCodigo())
				.dataAbertura(ordemServico.getDataAbertura())				
				.build();				
	}
	
	public OrdemServico mapTo(OrdemServicoDBEntity ordemServicoDBEntity) {		
		return objectMapper.map(ordemServicoDBEntity, OrdemServico.class);
	}

}
