package com.topcarservice.coreapi.infra.db.entities;

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
@Table(name = "veiculo")
public class VeiculoDBEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long codigo;
	
	private String placa;
	
	private String marca;
	
	private String modelo;
	
	private Integer ano;
	
	@ManyToOne
	@JoinColumn(name = "cliente_codigo")
	private ClienteDBEntity cliente;

}
