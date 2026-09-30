package com.topcarservice.coreapi.adapters.controllers.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoOrcamentoDTO {
	
	Long codigoOrdemServico;	
	String cliente;
	List<OrcamentoItemDTO> itens;	
	String dataOrcamento;	
	BigDecimal valorTotal;
	
	@Override
	public String toString() {
		return "+-----------Ordem Servico Orcamento -----------*\n" +
				"+-----codigoOrdemServico=" + codigoOrdemServico + "--------+\n" +
				"+-----cliente=" + cliente + "--------+\n" +
				"+-----itens=" + itens + "--------+\n" +
				"+-----dataOrcamento=" + dataOrcamento + "--------+\n" +
				"+-----valorTotal=" + valorTotal + "--------+\n" +
				"+---------------------------------------------+\n";
						
	}
	
	

}
