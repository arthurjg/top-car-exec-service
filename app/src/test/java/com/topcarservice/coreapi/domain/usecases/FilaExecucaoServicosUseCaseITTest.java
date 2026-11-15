package com.topcarservice.coreapi.domain.usecases;

import static org.assertj.core.api.Assertions.fail;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;

@ExtendWith(MockitoExtension.class)
class FilaExecucaoServicosUseCaseITTest {	
	
	@InjectMocks	
	FilaExecucaoServicosUseCase useCase;
	
	@Mock
	ServicoExecucaoUseCase servicoExecucaoUseCase;	
	
	@Mock
	ExecutorService executorFilaServicos;

	@Test
	void testAdicionarServicosSucesso() {
		
		List<ServicoExecucaoEntity> servicos = List.of(
				new ServicoExecucaoEntity(1L, "troca pastilha freio", 40L),
				new ServicoExecucaoEntity(1L, "troca filtro combustivel freio", 50L)				
				);
		
		try {
			useCase.adicionarServicos(servicos);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testAdicionarServicosErroDuracaoInicio() {
		
		List<ServicoExecucaoEntity> servicos = List.of(
				new ServicoExecucaoEntity(1L, "troca pastilha freio", 100L),
				new ServicoExecucaoEntity(1L, "troca filtro combustivel freio", 5000L)				
				);
		
		try {
			useCase.adicionarServicos(servicos);
			fail("Esperava exceção de tempo de execução");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
