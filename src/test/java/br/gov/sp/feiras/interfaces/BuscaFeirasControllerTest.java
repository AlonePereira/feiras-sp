package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.application.busca.BuscaFeiraService;
import br.gov.sp.feiras.application.vo.BuscaFeirasVO;
import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.interfaces.dto.FeiraDTORS;
import br.gov.sp.feiras.interfaces.dto.ParamBuscaFeiras;
import br.gov.sp.feiras.interfaces.mapper.FeiraDTOMapper;
import br.gov.sp.feiras.interfaces.mapper.ParamBuscaFeirasMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BuscaFeirasControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BuscaFeiraService service;

    @Mock
    private FeiraDTOMapper feiraDTOMapper;

    @Mock
    private ParamBuscaFeirasMapper paramBuscaFeirasMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new BuscaFeirasController(service, feiraDTOMapper, paramBuscaFeirasMapper))
                .build();
    }

    @Test
    void testBuscarFeirasComSucesso() throws Exception {
        Mockito.when(paramBuscaFeirasMapper.toBuscaFeirasVO(ArgumentMatchers.any(ParamBuscaFeiras.class)))
                .thenReturn(montarBuscaFeiraVO());
        Mockito.when(service.buscarFeiras(ArgumentMatchers.any(BuscaFeirasVO.class))).thenReturn(monstarListaFeirasVO());
        Mockito.when(feiraDTOMapper.toFeiraDTORSList(ArgumentMatchers.anyList())).thenReturn(monstarListaFeirasDTORS());

        mockMvc.perform(MockMvcRequestBuilders.get("/feiras?nomeFeira=VILA SONIA"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson()))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testBuscarFeirasComErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/feiras"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private BuscaFeirasVO montarBuscaFeiraVO() {
        var buscaFeirasVO = new BuscaFeirasVO();
        buscaFeirasVO.setNomeFeira("VILA SONIA");

        return buscaFeirasVO;
    }

    private List<FeiraVO> monstarListaFeirasVO() {

        FeiraVO feira = new FeiraVO();

        feira.setId(1L);
        feira.setLat(-46731043D);
        feira.setLon(-23592640D);
        feira.setSetcens("355030894000165");
        feira.setAreaP("3550308005179");
        feira.setCodDist(96);
        feira.setDistrito("VILA SONIA");
        feira.setCodigoSubPrefeitura(10);
        feira.setSubPrefeitura("BUTANTA");
        feira.setRegiao5("Oeste");
        feira.setRegiao8("Oeste");
        feira.setNomeFeira("VILA SONIA");
        feira.setRegistro("6034-8");
        feira.setLogradouro("AV GAL FRANCISCO MORAZAN");
        feira.setBairro("VL SONIA");
        feira.setReferencia("PROXIMO DISTRITO POLICIAL");

        return Collections.singletonList(feira);
    }

    private List<FeiraDTORS> monstarListaFeirasDTORS() {
        FeiraDTORS feira = new FeiraDTORS();

        feira.setId(1L);
        feira.setLat(-46731043D);
        feira.setLon(-23592640D);
        feira.setSetcens("355030894000165");
        feira.setAreaP("3550308005179");
        feira.setCodDist(96);
        feira.setDistrito("VILA SONIA");
        feira.setCodigoSubPrefeitura(10);
        feira.setSubPrefeitura("BUTANTA");
        feira.setRegiao5("Oeste");
        feira.setRegiao8("Oeste");
        feira.setNomeFeira("VILA SONIA");
        feira.setRegistro("6034-8");
        feira.setLogradouro("AV GAL FRANCISCO MORAZAN");
        feira.setBairro("VL SONIA");
        feira.setReferencia("PROXIMO DISTRITO POLICIAL");

        return Collections.singletonList(feira);
    }

    private String responseJson() throws Exception {
        return new ObjectMapper().writeValueAsString(monstarListaFeirasDTORS());
    }

}