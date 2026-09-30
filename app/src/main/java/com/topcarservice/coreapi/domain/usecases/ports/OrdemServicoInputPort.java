package com.topcarservice.coreapi.domain.usecases.ports;

import com.topcarservice.coreapi.domain.entities.OrdemServico;

public interface OrdemServicoInputPort {

	OrdemServico save(OrdemServico ordemServico);

	void delete(OrdemServico ordemServico);

}
