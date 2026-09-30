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
public class PecaInsumoDTO {
	
	private String nome;
	
	private String descricao;
	
	private String fabricante;
	
	private String modelo;
	
	private Integer quantidade;
	
	private BigDecimal valorUnitario;

}
