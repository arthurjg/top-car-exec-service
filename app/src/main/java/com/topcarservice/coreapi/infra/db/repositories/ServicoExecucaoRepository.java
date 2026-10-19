package com.topcarservice.coreapi.infra.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcarservice.coreapi.domain.entities.ServicoExecucaoEntity;

public interface ServicoExecucaoRepository extends JpaRepository<ServicoExecucaoEntity, Long> {

}
