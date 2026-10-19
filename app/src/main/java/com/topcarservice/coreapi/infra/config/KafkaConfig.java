package com.topcarservice.coreapi.infra.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoDTO;

@Configuration
public class KafkaConfig {
	
	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;	

	@Bean
	ConcurrentKafkaListenerContainerFactory<String, OrdemServicoDTO> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, OrdemServicoDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	private ConsumerFactory<String, OrdemServicoDTO> consumerFactory() {
		JacksonJsonDeserializer<OrdemServicoDTO> deserializer = new JacksonJsonDeserializer<>(OrdemServicoDTO.class);
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
	}

}
