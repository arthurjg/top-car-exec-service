package com.topcarservice.coreapi.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "servico_execucao")
public class ServicoExecucaoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long codigo;	
	
	private Long codigoOdemServico;	
	
	private StatusExecucaoServico status;	
	
	private String descricao;	
	
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

}
