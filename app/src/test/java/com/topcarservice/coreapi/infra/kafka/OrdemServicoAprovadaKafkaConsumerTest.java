package com.topcarservice.coreapi.infra.kafka;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;
import com.topcarservice.coreapi.domain.usecases.FilaExecucaoServicosUseCase;
import com.topcarservice.coreapi.domain.usecases.ServicoExecucaoUseCase;
import com.topcarservice.coreapi.infra.mappers.ServicoExecucaoMapper;

@ExtendWith(MockitoExtension.class)
class OrdemServicoAprovadaKafkaConsumerTest {
	
	@InjectMocks
	OrdemServicoAprovadaKafkaConsumer consumer;
	
	@Mock
	ServicoExecucaoUseCase servicoExecucaoUseCase;
	
	@Mock
	FilaExecucaoServicosUseCase filaExecucaoServicosUseCase;
	
	@Mock
	OrdemServicoFinalizadaKafkaProducer ordemServicoProducer;
	
	@Mock
	ServicoExecucaoMapper servicoExecucaoMapper;
	
	@Mock
	OrdemServicoAprovacaoDesfazerKafkaProducer oSAprovacaoDesfazerKafkaProducer;

	@Test
	void testRecebeEventoOSAprovadaOSInvalida() throws Exception {
		long codigoOrdemServico = 2L;
		
		var ordemServicoDTO = OrdemServicoRetornoDTO.builder()
				.codigo(codigoOrdemServico)
				.status("EM_DIAGNOSTICO")
				.build();	
		
		var servico = new ServicoExecucaoEntity();
		
		List<ServicoExecucaoEntity> servicos = List.of(servico);
		
		consumer.recebeEventoOSAprovada(ordemServicoDTO);
		
		verify(filaExecucaoServicosUseCase, times(0)).adicionarServicos(servicos);
	}
	
	@Test
	void testRecebeEventoOSAprovadaSucesso() throws Exception {
		long codigoOrdemServico = 2L;
		
		var ordemServicoDTO = OrdemServicoRetornoDTO.builder()
				.codigo(codigoOrdemServico)
				.status("EM_EXECUCAO")
				.build();	
		
		var servico = new ServicoExecucaoEntity();
		
		List<ServicoExecucaoEntity> servicos = List.of(servico);
		
		when(servicoExecucaoMapper.map(ordemServicoDTO)).thenReturn(servicos);
		
		consumer.recebeEventoOSAprovada(ordemServicoDTO);
		
		verify(filaExecucaoServicosUseCase).adicionarServicos(servicos);
		verify(ordemServicoProducer).sendOSAtualizadaEvent(ordemServicoDTO);
	}
	
	@Test
	void testRecebeEventoOSAprovadaErroExecucao() throws Exception {
		long codigoOrdemServico = 2L;
		
		var ordemServicoDTO = OrdemServicoRetornoDTO.builder()
				.codigo(codigoOrdemServico)
				.status("EM_EXECUCAO")
				.build();	
		
		var servico = new ServicoExecucaoEntity();
		
		List<ServicoExecucaoEntity> servicos = List.of(servico);
		
		when(servicoExecucaoMapper.map(ordemServicoDTO)).thenReturn(servicos);
		
		doThrow(new Exception("Erro ao iniciar execução do serviço")).when(filaExecucaoServicosUseCase).adicionarServicos(servicos);
		
		consumer.recebeEventoOSAprovada(ordemServicoDTO);
		
		verify(filaExecucaoServicosUseCase).adicionarServicos(servicos);
		verify(oSAprovacaoDesfazerKafkaProducer).sendOSAprovacaoDesfazerEvent(ordemServicoDTO);
	}

}
