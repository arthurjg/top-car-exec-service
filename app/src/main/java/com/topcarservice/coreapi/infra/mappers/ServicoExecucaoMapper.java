package com.topcarservice.coreapi.infra.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;

@Component
public class ServicoExecucaoMapper {	

	public List<ServicoExecucaoEntity> map(OrdemServicoRetornoDTO ordemServicoDTO) {		
		
		return ordemServicoDTO.getServicos()
				.stream()
				.map(servico -> new ServicoExecucaoEntity(
						ordemServicoDTO.getCodigo(),
						servico.getNome(),
						servico.getTempoExecucaoPrevisto())
					)
				.toList();
			
	}

}
