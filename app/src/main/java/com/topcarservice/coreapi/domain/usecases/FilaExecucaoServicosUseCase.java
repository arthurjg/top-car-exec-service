package com.topcarservice.coreapi.domain.usecases;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;
import com.topcarservice.coreapi.domain.entities.StatusExecucaoServico;
import com.topcarservice.coreapi.infra.kafka.OrdemServicoFinalizadaKafkaProducer;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class FilaExecucaoServicosUseCase {
	
	private ServicoExecucaoUseCase servicoExecucaoUseCase;	
	private ExecutorService executorFilaServicos;	
	
	public FilaExecucaoServicosUseCase(ServicoExecucaoUseCase servicoExecucaoUseCase,
			OrdemServicoFinalizadaKafkaProducer ordemServicoProducer) {
		super();
		this.servicoExecucaoUseCase = servicoExecucaoUseCase;
		this.executorFilaServicos = Executors.newFixedThreadPool(5);
	}	
	
	public void adicionarServicos(List<ServicoExecucaoEntity> servicos) throws Exception {
		
		
		Future<Boolean> resultado =  executorFilaServicos.submit(() -> {
			
			servicos.forEach(servico -> {
				
				log.info("Iniciando execução do serviço: {}, tempo: {}" , servico.getCodigo(), servico.getTempoExecucao());
				
				servico.setStatus(StatusExecucaoServico.EM_EXECUCAO);
				
				servicoExecucaoUseCase.cadastrar(servico);
				
				try {
					log.info("aguardando execução do serviço...");
					Thread.sleep(servico.getTempoExecucao());
					log.info("...serviço finalizado");
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				
				servico.setStatus(StatusExecucaoServico.FINALIZADO);
				
				servicoExecucaoUseCase.cadastrar(servico);
				
				log.info("Serviço finalizado: " + servico.getCodigo());
				
			});
			
			return true;
		});		
		
		try {
			resultado.get(100, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			String message = "Erro ao executar serviço, mecanico demorou para iniciar...";
			log.error(message);
			throw new Exception(message);			
		}			
		log.info("Serviços finalizados com sucesso.");						
	}
}
