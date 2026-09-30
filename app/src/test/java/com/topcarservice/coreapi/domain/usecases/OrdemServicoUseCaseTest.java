package com.topcarservice.coreapi.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoOutputPort;

@ExtendWith(MockitoExtension.class)
class OrdemServicoUseCaseTest {
	
	@InjectMocks
	OrdemServicoUseCase useCase;
	
	@Mock
	OrdemServicoInputPort inputPort;
	
	@Mock
	OrdemServicoOutputPort outputPort;

	@Test
	void testCadastrar() {
		OrdemServico ordemServico = new OrdemServico();		
		
		useCase.cadastrar(ordemServico);
		
		verify(inputPort).save(ordemServico);
	}
	
	@Test
	void testCarregar() {
		
		long codigo = 1L;
		
		OrdemServico ordemServico = new OrdemServico();
		
		when(outputPort.findById(codigo)).thenReturn(Optional.of(ordemServico));
		
		OrdemServico ordemServicoResult = useCase.carregar(codigo);
		
		assertNotNull(ordemServicoResult);
		assertEquals(ordemServico.getCodigo(), ordemServicoResult.getCodigo());
	}

}
