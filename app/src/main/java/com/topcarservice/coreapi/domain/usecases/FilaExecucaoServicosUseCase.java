package com.topcarservice.coreapi.domain.usecases;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;
import com.topcarservice.coreapi.domain.entities.StatusExecucaoServico;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class FilaExecucaoServicosUseCase {
	
	private ServicoExecucaoUseCase servicoExecucaoUseCase;	
	private ExecutorService executorFilaServicos;
	
	public FilaExecucaoServicosUseCase(ServicoExecucaoUseCase servicoExecucaoUseCase) {
		super();
		this.servicoExecucaoUseCase = servicoExecucaoUseCase;
		this.executorFilaServicos = Executors.newFixedThreadPool(5);
	}	
	
	public void adicionarServicos(List<ServicoExecucaoEntity> servicos) {
		
		
		Future<Boolean> resultado =  executorFilaServicos.submit(() -> {
			
			servicos.forEach(servico -> {
				
				log.info("Iniciando execução do serviço: {}, tempo: {}" , servico.getCodigo(), servico.getTempoExecucao());
				
				servico.setStatus(StatusExecucaoServico.EM_EXECUCAO);
				
				servicoExecucaoUseCase.cadastrar(servico);
				
				try {
					log.info("aguardando serviço...");
					Thread.sleep(servico.getTempoExecucao());
					log.info("...serviço finalizado");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				servico.setStatus(StatusExecucaoServico.FINALIZADO);
				
				servicoExecucaoUseCase.cadastrar(servico);
				
				log.info("Serviço finalizado: " + servico.getCodigo());
				
			});
			
			return true;
		});
		
		try {
			resultado.get();
			log.info("Serviços finalizados com sucesso.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Erro ao executar Serviços.");
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Erro ao executar Serviços.");
		}
		
		//TODO os finalizada execucao
		
	}
	
	
	
	
	

	

}
