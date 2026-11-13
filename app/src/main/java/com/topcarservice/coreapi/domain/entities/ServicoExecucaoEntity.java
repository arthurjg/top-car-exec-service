package com.topcarservice.coreapi.domain.entities;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class ServicoExecucaoEntity {
	
	@Setter
	private Long codigo;	
	
	private Long codigoOdemServico;	
	
	@Getter
	@Setter
	private StatusExecucaoServico status;	
	
	private String descricao;	
	
	@Getter
	private Long tempoExecucao;	
	
	private LocalDateTime dataAbertura;
	
	private LocalDateTime dataInicioExecucao;
	
	private LocalDateTime dataFimExecucao;

	public ServicoExecucaoEntity() {
		super();
		status = StatusExecucaoServico.PENDENTE;
	}
	
	public ServicoExecucaoEntity(Long codigoOdemServico, String descricao, Long tempoExecucao) {
		this();
		this.codigoOdemServico = codigoOdemServico;
		this.descricao = descricao;
		this.tempoExecucao = tempoExecucao;
	}

	@DynamoDbPartitionKey
	public Long getCodigo() {
		return codigo;
	}	
	
	

}
