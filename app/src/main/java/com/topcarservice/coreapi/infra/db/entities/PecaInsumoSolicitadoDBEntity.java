package com.topcarservice.coreapi.infra.db.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "peca_insumo_solicitado")
public class PecaInsumoSolicitadoDBEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long codigo;	
	
	private String nome;	
	
	private String modelo;
	
	private Integer quantidade;
	
	private BigDecimal valorUnitario;
	
	@ManyToOne
	@JoinColumn(name = "peca_insumo_codigo")	
	private PecaInsumoDBEntity pecaInsumo;

}
