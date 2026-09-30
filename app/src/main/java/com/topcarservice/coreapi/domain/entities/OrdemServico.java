package com.topcarservice.coreapi.domain.entities;

import java.time.LocalDateTime;

public class OrdemServico {
	
	private Long codigo;	
	
	private StatusOrdemServico status;		
	
	private LocalDateTime dataAbertura;

	public OrdemServico() {
		super();
		dataAbertura = LocalDateTime.now();
		status = StatusOrdemServico.RECEBIDA;			
	}		

	@Deprecated
	public OrdemServico(Long codigo, StatusOrdemServico status, LocalDateTime dataAbertura) {
		super();
		this.codigo = codigo;
		this.status = status;		
		this.dataAbertura = dataAbertura;
	}	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}	

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}		

}
