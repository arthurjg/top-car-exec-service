package com.topcarservice.coreapi.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.topcarservice.coreapi.domain.usecases.OrdemServicoUseCase;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoOutputPort;

@Configuration
public class UseCasesConfig {
	
	@Bean
	OrdemServicoUseCase ordemServicoUseCase(OrdemServicoInputPort inputPort, OrdemServicoOutputPort outputPort) {
		return new OrdemServicoUseCase(inputPort, outputPort);
	}

}
