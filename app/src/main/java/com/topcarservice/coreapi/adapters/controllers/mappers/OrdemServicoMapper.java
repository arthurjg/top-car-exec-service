package com.topcarservice.coreapi.adapters.controllers.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoPecaInsumoSolicitadoDTO;
import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoSolicitadoRetornoDTO;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.infra.utils.DateTimeUtil;

@Component
public class OrdemServicoMapper {
	
	@Autowired
	private ModelMapper objectMapper;	

	public OrdemServico map(OrdemServicoDTO ordemServicoDto) {		
		return objectMapper.map(ordemServicoDto, OrdemServico.class);
	}
	
	//TODO
	public OrdemServicoRetornoDTO map(OrdemServico ordemServico) {			
		
		List<OrdemServicoSolicitadoRetornoDTO> servicosSolicitados = null;
				/*ordemServico.getServicos()
				.stream()
				.map(servicoSolicitadoEntity -> servicoSolicitadoMapper.mapTo(servicoSolicitadoEntity))
				.toList();*/
		
		List<OrdemServicoPecaInsumoSolicitadoDTO> pecasInsumosSolicitados = null;
				/*ordemServico.getPecasInsumos()
				.stream()
				.map(pecaInsumoSolicitado -> pecaInsumoSolicitadoMapper.mapTo(pecaInsumoSolicitado))
				.toList(); TODO TEST ALTERAR */
		
		return OrdemServicoRetornoDTO.builder()
				.codigo(ordemServico.getCodigo())
				.status(ordemServico.getStatus().name())				
				.dataAbertura(DateTimeUtil.formatarDataHora(ordemServico.getDataAbertura()))
				.servicos(servicosSolicitados)
				.pecasInsumos(pecasInsumosSolicitados)
				.build();
	}

	public List<OrdemServicoRetornoDTO> map(List<OrdemServico> ordemsServico) {		
		return ordemsServico.stream()
				.map(ordemServico -> map(ordemServico))
				.toList();
	}	

}
