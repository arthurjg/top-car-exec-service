package com.topcarservice.coreapi.infra.db.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "ordem_servico")
public class OrdemServicoDBEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Long codigo;
	
	@Setter
	private Integer status;	
	
	@ManyToOne
	@JoinColumn(name = "cliente_codigo")	
	private ClienteDBEntity cliente;
	
	@ManyToOne
	@JoinColumn(name = "veiculo_codigo")	
	private VeiculoDBEntity veiculo;
	
	@OneToMany
	private List<ServicoSolicitadoDBEntity> servicos;
	
	@OneToMany
	private List<PecaInsumoSolicitadoDBEntity> pecasInsumos;
	
	private LocalDateTime dataAbertura;

}
