package com.topcarservice.coreapi.domain.entities;

public enum StatusExecucaoServico {	
	
	PENDENTE(1, "PENDENTE"),	
	EM_EXECUCAO(2, "EM_EXECUCAO"),
	FINALIZADO(3, "FINALIZADO");
	
	
	private int codigo;
	private String descricao;
	
	private StatusExecucaoServico(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}	

}
