package com.topcarservice.coreapi.domain.usecases;

import java.util.List;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoOutputPort;


public class OrdemServicoUseCase {
	
	private final OrdemServicoInputPort inputPort;
	private final OrdemServicoOutputPort outputPort;
	
	public OrdemServicoUseCase(OrdemServicoInputPort inputPort, OrdemServicoOutputPort outputPort) {
		this.inputPort = inputPort;
		this.outputPort = outputPort;
	}

	public OrdemServico cadastrar(OrdemServico ordemServico) {
		return inputPort.save(ordemServico);		
	}

	public OrdemServico carregar(Long codigo) {
		
		return outputPort.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("OrdemServico não encontrado"));
	}

	public void excluir(OrdemServico ordemServico) {
		inputPort.delete(ordemServico);		
	}

	public List<OrdemServico> listar() {		
		return outputPort.findAll();
	}

}
