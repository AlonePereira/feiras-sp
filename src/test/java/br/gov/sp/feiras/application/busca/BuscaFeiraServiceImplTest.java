package br.gov.sp.feiras.application.busca;

import br.gov.sp.feiras.application.mapper.FeiraVOMapper;
import br.gov.sp.feiras.application.vo.BuscaFeirasVO;
import br.gov.sp.feiras.entity.repository.FeiraRepository;
import br.gov.sp.feiras.entity.repository.FeiraSpecificationFactoryComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuscaFeiraServiceImplTest {

    @Mock
    private FeiraRepository repository;

    @Mock
    private FeiraSpecificationFactoryComponent specificationFactoryComponent;

    @Mock
    private FeiraVOMapper feiraVOMapper;

    private BuscaFeiraServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new BuscaFeiraServiceImpl(repository, specificationFactoryComponent, feiraVOMapper);
    }

    @Test
    void testBuscarFeiras() {
        var specification = Mockito.mock(Specification.class);
        Mockito.when(specificationFactoryComponent.getSpecification(ArgumentMatchers.any(BuscaFeirasVO.class))).thenReturn(specification);
        Mockito.when(repository.findAll(ArgumentMatchers.any(Specification.class))).thenReturn(Collections.emptyList());
        Mockito.when(feiraVOMapper.toFeiraVOList(ArgumentMatchers.anyList())).thenReturn(Collections.emptyList());

        assertDoesNotThrow(() -> service.buscarFeiras(montarBuscaFeiras()), "Buscar Feiras Não deveria Lançar Exception");

        Mockito.verify(repository).findAll(ArgumentMatchers.any(Specification.class));
        Mockito.verify(specificationFactoryComponent).getSpecification(ArgumentMatchers.any(BuscaFeirasVO.class));
        Mockito.verify(feiraVOMapper).toFeiraVOList(ArgumentMatchers.anyList());
    }

    private BuscaFeirasVO montarBuscaFeiras() {
        var buscaFeirasVO = new BuscaFeirasVO();
        buscaFeirasVO.setNomeFeira("VILA FORMOSA");

        return buscaFeirasVO;
    }

}