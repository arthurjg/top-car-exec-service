package com.topcarservice.coreapi.adapters.controllers.dto;

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
public class VeiculoDTO { 	
	
	private String placa;
	
	private String marca;
	
	private String modelo;
	
	private Integer ano;
	
	private Long codigoCliente;
	
}
