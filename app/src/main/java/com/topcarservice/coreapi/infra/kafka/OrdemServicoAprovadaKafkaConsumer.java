package com.topcarservice.coreapi.infra.kafka;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;
import com.topcarservice.coreapi.domain.entities.StatusOrdemServico;
import com.topcarservice.coreapi.domain.usecases.FilaExecucaoServicosUseCase;
import com.topcarservice.coreapi.domain.usecases.ServicoExecucaoUseCase;
import com.topcarservice.coreapi.infra.mappers.ServicoExecucaoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdemServicoAprovadaKafkaConsumer {
	
	private static final String ORDEM_SERVICO_ATUALIZADA_TOPIC = "ordem-servico-atualizada";
	
	private final ServicoExecucaoUseCase servicoExecucaoUseCase;
	
	private final ServicoExecucaoMapper servicoExecucaoMapper;
	
	private final FilaExecucaoServicosUseCase filaExecucaoServicosUseCase;
	
	private final OrdemServicoFinalizadaKafkaProducer ordemServicoProducer;
	
	@KafkaListener(topics = ORDEM_SERVICO_ATUALIZADA_TOPIC, groupId = "${spring.kafka.consumer.group-id}")
	public void recebeEventoOSAprovada(OrdemServicoRetornoDTO ordemServicoDTO) {
		
		log.info("Ordem Serviço atualizada recebida no tópico: {}.", ordemServicoDTO.getCodigo());
		
		if(!ordemServicoDTO.getStatus().equals(StatusOrdemServico.EM_EXECUCAO.getDescricao())) {
			log.info("Ordem de serviço {} não está em execução. Nenhuma ação será tomada.", ordemServicoDTO.getCodigo());
			return;
		}
		
		List<ServicoExecucaoEntity> servicos = servicoExecucaoMapper.map(ordemServicoDTO);
		
		servicos.forEach(servico -> {
			servicoExecucaoUseCase.cadastrar(servico);
		});		
		
		log.info("Execução de Serviço enviada para a fila.");
		
		filaExecucaoServicosUseCase.adicionarServicos(servicos);
		
		ordemServicoProducer.sendOSAtualizadaEvent(ordemServicoDTO);
		
		log.info("Ordem de serviço {} finalizada enviada para o tópico.", ordemServicoDTO.getCodigo());			
		
	}

}
