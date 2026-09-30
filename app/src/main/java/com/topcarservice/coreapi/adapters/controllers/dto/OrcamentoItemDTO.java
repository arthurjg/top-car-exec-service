package com.topcarservice.coreapi.adapters.controllers.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrcamentoItemDTO {
	
	String descricao;
	Integer quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	
	@Override
	public String toString() {
		return "*----- descricao=" + descricao + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", valorTotal=" + valorTotal + "----*";
	}
	
	

}
