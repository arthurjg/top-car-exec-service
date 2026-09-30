package com.topcarservice.coreapi.repository;

/*
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.junit.jupiter.api.Assertions.assertNull; import static
 * org.junit.jupiter.api.Assertions.assertTrue;
 * 
 * import java.util.Optional;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest; import
 * org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
 * 
 * import com.topcarservice.coreapi.domain.Veiculo;
 * 
 * @DataJpaTest class VeiculoRepositoryITTest {
 * 
 * @Autowired private VeiculoRepository veiculoRepository;
 * 
 * @Autowired private TestEntityManager entityManager;
 * 
 * Veiculo veiculo;
 * 
 * @BeforeEach void setUp() throws Exception {
 * 
 * veiculo = Veiculo.builder() .placa("QHU-5R66") .marca("Porche")
 * .modelo("Cayenne") .ano(2022) .build(); }
 * 
 * @Test void criaVeiculo_ComDadosValidos_RetornaVeiculo() {
 * 
 * Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
 * 
 * var veiculoResultado = entityManager.find(Veiculo.class,
 * veiculoSalvo.getCodigo());
 * 
 * assertNotNull(veiculoResultado); assertEquals(veiculoResultado.getPlaca(),
 * veiculo.getPlaca()); assertEquals(veiculoResultado.getMarca(),
 * veiculo.getMarca()); assertEquals(veiculoResultado.getModelo(),
 * veiculo.getModelo()); assertEquals(veiculoResultado.getAno(),
 * veiculo.getAno()); }
 * 
 * @Test void carregaVeiculo_ComCodigoValido_RetornaVeiculo() {
 * 
 * Veiculo veiculoSalvo = entityManager.persist(veiculo);
 * 
 * Optional<Veiculo> op = veiculoRepository.findById(veiculoSalvo.getCodigo());
 * 
 * var veiculoResultado = entityManager.find(Veiculo.class,
 * veiculoSalvo.getCodigo());
 * 
 * assertTrue(op.isPresent()); assertNotNull(veiculoResultado);
 * 
 * }
 * 
 * @Test void atualizaVeiculo_ComCodigoValido_RetornaVeiculo() {
 * 
 * Veiculo veiculoSalvo = entityManager.persist(veiculo);
 * 
 * veiculoSalvo = entityManager.find(Veiculo.class, veiculoSalvo.getCodigo());
 * 
 * veiculoSalvo.setModelo("Cayenne S Plus");
 * 
 * var veiculoResultado = veiculoRepository.save(veiculoSalvo);
 * 
 * assertNotNull(veiculoResultado); assertEquals(veiculoSalvo.getModelo(),
 * veiculoResultado.getModelo());
 * 
 * }
 * 
 * @Test void removeVeiculo_ComCodigoValido_RetornaVazio() {
 * 
 * Veiculo veiculoSalvo = entityManager.persist(veiculo);
 * 
 * var veiculoResultado = entityManager.find(Veiculo.class,
 * veiculoSalvo.getCodigo());
 * 
 * veiculoRepository.deleteById(veiculoResultado.getCodigo());
 * 
 * veiculoResultado = entityManager.find(Veiculo.class,
 * veiculoResultado.getCodigo());
 * 
 * assertNull(veiculoResultado); }
 * 
 * }
 */
