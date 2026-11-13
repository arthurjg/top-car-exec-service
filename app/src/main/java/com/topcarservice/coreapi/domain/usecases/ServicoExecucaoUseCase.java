package com.topcarservice.coreapi.domain.usecases;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;
import com.topcarservice.coreapi.infra.db.repositories.ServicoExecucaoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ServicoExecucaoUseCase {
	
	private final ServicoExecucaoRepository servicoExecucaoRepository;	

	public ServicoExecucaoEntity cadastrar(ServicoExecucaoEntity servicoExecucaoEntity) {
		return servicoExecucaoRepository.save(servicoExecucaoEntity);		
	}

}
