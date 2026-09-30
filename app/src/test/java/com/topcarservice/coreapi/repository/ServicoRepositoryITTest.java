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
 * import com.topcarservice.coreapi.domain.Servico;
 * 
 * @DataJpaTest class ServicoRepositoryITTest {
 * 
 * @Autowired private ServicoRepository servicoRepository;
 * 
 * @Autowired private TestEntityManager entityManager;
 * 
 * Servico servico;
 * 
 * @BeforeEach void setUp() throws Exception {
 * 
 * servico = Servico.builder() .nome("Troca de óleo") .build(); }
 * 
 * @Test void criaServico_ComDadosValidos_RetornaServico() {
 * 
 * Servico servicoSalvo = servicoRepository.save(servico);
 * 
 * var servicoResultado = entityManager.find(Servico.class,
 * servicoSalvo.getCodigo());
 * 
 * assertNotNull(servicoResultado); assertEquals(servicoResultado.getNome(),
 * servico.getNome()); }
 * 
 * @Test void carregaServico_ComCodigoValido_RetornaServico() {
 * 
 * Servico servicoSalvo = entityManager.persist(servico);
 * 
 * Optional<Servico> op = servicoRepository.findById(servicoSalvo.getCodigo());
 * 
 * var servicoResultado = entityManager.find(Servico.class,
 * servicoSalvo.getCodigo());
 * 
 * assertTrue(op.isPresent()); assertNotNull(servicoResultado);
 * 
 * }
 * 
 * @Test void atualizaServico_ComCodigoValido_RetornaServico() {
 * 
 * Servico servicoSalvo = entityManager.persist(servico);
 * 
 * servicoSalvo = entityManager.find(Servico.class, servicoSalvo.getCodigo());
 * 
 * servicoSalvo.setNome("Troca de óleo e filtro");
 * 
 * var servicoResultado = servicoRepository.save(servicoSalvo);
 * 
 * assertNotNull(servicoResultado); assertEquals(servicoSalvo.getNome(),
 * servicoResultado.getNome());
 * 
 * }
 * 
 * @Test void removeServico_ComCodigoValido_RetornaVazio() {
 * 
 * Servico servicoSalvo = entityManager.persist(servico);
 * 
 * var servicoResultado = entityManager.find(Servico.class,
 * servicoSalvo.getCodigo());
 * 
 * servicoRepository.deleteById(servicoResultado.getCodigo());
 * 
 * servicoResultado = entityManager.find(Servico.class,
 * servicoResultado.getCodigo());
 * 
 * assertNull(servicoResultado); }
 * 
 * }
 */
