package com.topcarservice.coreapi.infra.db.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "servico_solicitado")
public class ServicoSolicitadoDBEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long codigo;	
	
	private String nome;
	
	private BigDecimal valorMaoDeObra;		
	
	@ManyToOne
	private ServicoDBEntity servico;

}
