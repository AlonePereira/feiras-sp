package br.gov.sp.feiras.application.cria;

import br.gov.sp.feiras.application.mapper.FeiraVOMapper;
import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.entity.Feira;
import br.gov.sp.feiras.entity.repository.FeiraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CriaFeiraServiceImplTest {

    @Mock
    private FeiraRepository repository;

    @Mock
    private FeiraVOMapper feiraVOMapper;

    private CriaFeiraServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new CriaFeiraServiceImpl(repository, feiraVOMapper);
    }

    @Test
    void testCriarFeira() {
        Mockito.when(feiraVOMapper.toFeira(ArgumentMatchers.any(FeiraVO.class))).thenReturn(new Feira());
        Mockito.when(repository.save(ArgumentMatchers.any(Feira.class))).thenReturn(new Feira());
        Mockito.when(feiraVOMapper.toFeiraVO(ArgumentMatchers.any(Feira.class))).thenReturn(new FeiraVO());

        assertDoesNotThrow(() -> service.criarFeira(new FeiraVO()),
                "Criação da Feira não deveria lançar Exception");

        Mockito.verify(feiraVOMapper).toFeira(ArgumentMatchers.any(FeiraVO.class));
        Mockito.verify(feiraVOMapper).toFeiraVO(ArgumentMatchers.any(Feira.class));
        Mockito.verify(repository).save(ArgumentMatchers.any(Feira.class));
    }

}