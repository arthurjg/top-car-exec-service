package com.topcarservice.coreapi.infra.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcarservice.coreapi.infra.db.entities.OrdemServicoDBEntity;

public interface OrdemServicoRepository extends JpaRepository<OrdemServicoDBEntity, Long> {

}
