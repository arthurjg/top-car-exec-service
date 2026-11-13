package com.topcarservice.coreapi.infra.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	ModelMapper modelMapper() {				
		var modelMapper = new ModelMapper();		
		
		return modelMapper;
	}

}
