package com.topcarservice.coreapi.infra.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoSolicitadoRetornoDTO;
import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;

class ServicoExecucaoMapperTest {
	
	ServicoExecucaoMapper mapper;
	
	@BeforeEach
	void init() {
		mapper = new ServicoExecucaoMapper();
	}

	@Test
	void testMap() {
		
		OrdemServicoSolicitadoRetornoDTO servico = OrdemServicoSolicitadoRetornoDTO.builder()
				.codigoServico(1L)
				.nome("troca oleo")
				.tempoExecucaoPrevisto(80L)
				.build();
		
		List<OrdemServicoSolicitadoRetornoDTO> servicos = List.of(servico);
		
		var ordemServicoDTO = OrdemServicoRetornoDTO.builder()
				.codigo(1L)
				.servicos(servicos)				
				.build();		
		
		List<ServicoExecucaoEntity> servicosResult = mapper.map(ordemServicoDTO);		
		
		assertNotNull(servicosResult);		
		assertEquals(1, servicosResult.size());
		assertNotNull(servicosResult.getFirst());	
		
	}

}
