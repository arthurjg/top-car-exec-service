package com.topcarservice.coreapi.domain.usecases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;
import com.topcarservice.coreapi.infra.db.repositories.ServicoExecucaoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ServicoExecucaoUseCase {
	
	private final ServicoExecucaoRepository ordemServicoRepository;	

	public ServicoExecucaoEntity cadastrar(ServicoExecucaoEntity ordemServico) {
		return ordemServicoRepository.save(ordemServico);		
	}

	public ServicoExecucaoEntity carregar(Long codigo) {
		
		return ordemServicoRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("OrdemServico não encontrada"));
	}

	public void excluir(ServicoExecucaoEntity ordemServico) {
		ordemServicoRepository.delete(ordemServico);		
	}

	public List<ServicoExecucaoEntity> listar() {		
		return ordemServicoRepository.findAll();
	}

}
