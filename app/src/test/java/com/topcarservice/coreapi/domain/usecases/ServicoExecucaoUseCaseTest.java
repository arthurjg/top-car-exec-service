package com.topcarservice.coreapi.domain.usecases;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;
import com.topcarservice.coreapi.infra.db.repositories.ServicoExecucaoRepository;

@ExtendWith(MockitoExtension.class)
class ServicoExecucaoUseCaseTest {
	
	@InjectMocks
	ServicoExecucaoUseCase useCase;
	
	@Mock
	ServicoExecucaoRepository repository;

	@Test
	void testCadastrar() {
		
		var servicoExecucaoEntity = new ServicoExecucaoEntity();
		
		useCase.cadastrar(servicoExecucaoEntity);
		
		verify(repository).save(servicoExecucaoEntity);
	}

}
