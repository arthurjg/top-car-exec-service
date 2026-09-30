package com.topcarservice.coreapi.adapters.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AutorizacaoDTO {	
	
	@NotBlank
	private String login;	
	
	@NotBlank
	private String senha;

}
