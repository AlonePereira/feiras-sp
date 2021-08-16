package br.gov.sp.feiras.application.atualiza;

import br.gov.sp.feiras.application.exception.FeiraNotFound;
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
class AtualizaFeiraServiceImplTest {

    @Mock
    private FeiraRepository repository;

    @Mock
    private FeiraVOMapper feiraVOMapper;

    private AtualizaFeiraServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new AtualizaFeiraServiceImpl(repository, feiraVOMapper);
    }

    @Test
    void testAtualizaFeiraComSucesso() {
        Mockito.when(repository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
        Mockito.when(repository.save(ArgumentMatchers.any(Feira.class))).thenReturn(new Feira());
        Mockito.when(feiraVOMapper.toFeira(ArgumentMatchers.any(FeiraVO.class))).thenReturn(new Feira());
        Mockito.when(feiraVOMapper.toFeiraVO(ArgumentMatchers.any(Feira.class))).thenReturn(new FeiraVO());


        var feiraVO = new FeiraVO();
        feiraVO.setId(1L);
        assertDoesNotThrow(() -> service.atualizarFeira(feiraVO),
                "Não deveria lançar Exception na atualização da Feira");

    }

    @Test
    void testAtualizaFeiraComFeiraInexistente() {
        Mockito.when(repository.existsById(ArgumentMatchers.anyLong())).thenReturn(false);

        var feiraVO = new FeiraVO();
        feiraVO.setId(1L);
        assertThrows(FeiraNotFound.class, () -> service.atualizarFeira(feiraVO),
                "Deveria Lançar uma FeiraNotFound");
    }

}