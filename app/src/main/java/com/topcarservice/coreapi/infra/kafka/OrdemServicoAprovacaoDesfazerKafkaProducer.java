package com.topcarservice.coreapi.infra.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrdemServicoAprovacaoDesfazerKafkaProducer {
	
	private final KafkaTemplate<String, OrdemServicoRetornoDTO> kafkaTemplate;
	
	private static final String OS_APROVACAO_DESFAZER_TOPIC = "ordem-servico-aprovacao-desfazer";
	
	public void sendOSAprovacaoDesfazerEvent(OrdemServicoRetornoDTO ordemServico) {
		
		kafkaTemplate.send(OS_APROVACAO_DESFAZER_TOPIC, ordemServico);		
		
	}

}
