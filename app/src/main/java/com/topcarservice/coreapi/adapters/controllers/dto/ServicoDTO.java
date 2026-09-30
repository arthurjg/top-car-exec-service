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
public class ServicoDTO {		
	
	private String nome;
	
	private BigDecimal valorMaoDeObra;

}
