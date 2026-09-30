package com.topcarservice.coreapi.infra.db.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.infra.db.entities.ClienteDBEntity;
import com.topcarservice.coreapi.infra.db.entities.OrdemServicoDBEntity;
import com.topcarservice.coreapi.infra.db.repositories.OrdemServicoRepository;

@DataJpaTest
class OrdemServicoRepositoryITTest {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private TestEntityManager entityManager;

	private OrdemServicoDBEntity ordemServico;

	@BeforeEach
	void setUp() throws Exception {

		ClienteDBEntity clienteSalvo = entityManager
				.persist(ClienteDBEntity.builder().nome("ClienteDBEntity Teste").build());

		ordemServico = OrdemServicoDBEntity
				.builder()
				.cliente(clienteSalvo)
				.build();
	}

	/*
	 * @Test void listaOrdemServico_ComCodigoValido_RetornaListaOrdemServico() {
	 * 
	 * entityManager.persist(ordemServico);
	 * 
	 * List<OrdemServicoDBEntity> ordemServicoListResultado =
	 * ordemServicoRepository.findAll();
	 * 
	 * assertNotNull(ordemServicoListResultado);
	 * assertFalse(ordemServicoListResultado.isEmpty());
	 * assertTrue(ordemServicoListResultado.size() == 1);
	 * 
	 * }
	 */

	@Test
	void criaOrdemServico_ComDadosValidos_RetornaOrdemServico() {

		OrdemServicoDBEntity ordemServicoSalvo = ordemServicoRepository.save(ordemServico);

		var ordemServicoResultado = entityManager.find(OrdemServicoDBEntity.class, ordemServicoSalvo.getCodigo());

		assertNotNull(ordemServicoResultado);
		assertEquals(ordemServicoResultado.getDataAbertura(), ordemServico.getDataAbertura());
		assertEquals(ordemServicoResultado.getStatus(), ordemServico.getStatus());
		assertEquals(ordemServicoResultado.getCodigo(), ordemServico.getCodigo());		
	}

	/*
	 * @Test void carregaOrdemServico_ComCodigoValido_RetornaOrdemServico() {
	 * 
	 * OrdemServico ordemServicoSalvo = entityManager.persist(ordemServico);
	 * 
	 * Optional<OrdemServico> op =
	 * ordemServicoRepository.findById(ordemServicoSalvo.getCodigo());
	 * 
	 * var ordemServicoResultado = entityManager.find(OrdemServico.class,
	 * ordemServicoSalvo.getCodigo());
	 * 
	 * assertTrue(op.isPresent()); assertNotNull(ordemServicoResultado);
	 * assertEquals(ordemServicoSalvo, ordemServicoResultado);
	 * 
	 * }
	 */

	/*
	 * @Test void atualizaOrdemServico_ComCodigoValido_RetornaOrdemServico() {
	 * 
	 * OrdemServico ordemServicoSalvo = entityManager.persist(ordemServico);
	 * 
	 * ordemServicoSalvo = entityManager.find(OrdemServico.class,
	 * ordemServicoSalvo.getCodigo());
	 * 
	 * ordemServicoSalvo.setModelo("Cayenne S Plus");
	 * 
	 * var ordemServicoResultado = ordemServicoRepository.save(ordemServicoSalvo);
	 * 
	 * assertNotNull(ordemServicoResultado);
	 * assertEquals(ordemServicoSalvo.getModelo(),
	 * ordemServicoResultado.getModelo());
	 * 
	 * }
	 */

}
