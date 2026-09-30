package com.topcarservice.coreapi.repository;

/*
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.junit.jupiter.api.Assertions.assertNull; import static
 * org.junit.jupiter.api.Assertions.assertTrue;
 * 
 * import java.math.BigDecimal; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest; import
 * org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
 * 
 * import com.topcarservice.coreapi.domain.PecaInsumo;
 * 
 * @DataJpaTest class PecaInsumoRepositoryITTest {
 * 
 * @Autowired private PecaInsumoRepository pecaInsumoRepository;
 * 
 * @Autowired private TestEntityManager entityManager;
 * 
 * PecaInsumo pecaInsumo;
 * 
 * @BeforeEach void setUp() throws Exception {
 * 
 * pecaInsumo = PecaInsumo.builder() .nome("Pastilha de roda")
 * .descricao("Pastilha de freio para veículos de passeio")
 * .fabricante("Brembo") .modelo("Ceramic") .quantidade(50) .valorUnitario(new
 * BigDecimal("150.00")) .build(); }
 * 
 * @Test void criaPecaInsumo_ComDadosValidos_RetornaPecaInsumo() {
 * 
 * PecaInsumo pecaInsumoSalvo = pecaInsumoRepository.save(pecaInsumo);
 * 
 * var pecaInsumoResultado = entityManager.find(PecaInsumo.class,
 * pecaInsumoSalvo.getCodigo());
 * 
 * assertNotNull(pecaInsumoResultado);
 * assertEquals(pecaInsumoResultado.getNome(), pecaInsumo.getNome()); }
 * 
 * @Test void carregaPecaInsumo_ComCodigoValido_RetornaPecaInsumo() {
 * 
 * PecaInsumo pecaInsumoSalvo = entityManager.persist(pecaInsumo);
 * 
 * Optional<PecaInsumo> op =
 * pecaInsumoRepository.findById(pecaInsumoSalvo.getCodigo());
 * 
 * var pecaInsumoResultado = entityManager.find(PecaInsumo.class,
 * pecaInsumoSalvo.getCodigo());
 * 
 * assertTrue(op.isPresent()); assertNotNull(pecaInsumoResultado);
 * 
 * }
 * 
 * @Test void atualizaPecaInsumo_ComCodigoValido_RetornaPecaInsumo() {
 * 
 * PecaInsumo pecaInsumoSalvo = entityManager.persist(pecaInsumo);
 * 
 * pecaInsumoSalvo = entityManager.find(PecaInsumo.class,
 * pecaInsumoSalvo.getCodigo());
 * 
 * pecaInsumoSalvo.setNome("Pastilha de freio");
 * 
 * var pecaInsumoResultado = pecaInsumoRepository.save(pecaInsumoSalvo);
 * 
 * assertNotNull(pecaInsumoResultado); assertEquals(pecaInsumoSalvo.getNome(),
 * pecaInsumoResultado.getNome());
 * 
 * }
 * 
 * @Test void removePecaInsumo_ComCodigoValido_RetornaVazio() {
 * 
 * PecaInsumo pecaInsumoSalvo = entityManager.persist(pecaInsumo);
 * 
 * var pecaInsumoResultado = entityManager.find(PecaInsumo.class,
 * pecaInsumoSalvo.getCodigo());
 * 
 * pecaInsumoRepository.deleteById(pecaInsumoResultado.getCodigo());
 * 
 * pecaInsumoResultado = entityManager.find(PecaInsumo.class,
 * pecaInsumoResultado.getCodigo());
 * 
 * assertNull(pecaInsumoResultado); }
 * 
 * }
 */
