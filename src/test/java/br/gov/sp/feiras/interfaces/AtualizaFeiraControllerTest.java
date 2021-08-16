package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.application.atualiza.AtualizaFeiraService;
import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import br.gov.sp.feiras.interfaces.dto.FeiraDTORS;
import br.gov.sp.feiras.interfaces.mapper.FeiraDTOMapper;
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

@ExtendWith(MockitoExtension.class)
class AtualizaFeiraControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AtualizaFeiraService service;

    @Mock
    private FeiraDTOMapper mapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AtualizaFeiraController(service, mapper)).build();
    }

    @Test
    void testAtualizarFeiraComSucesso() throws Exception {
        Mockito.when(service.atualizarFeira(ArgumentMatchers.any(FeiraVO.class))).thenReturn(montarFeiraVO());
        Mockito.when(mapper.toFeiraVO(ArgumentMatchers.anyLong(), ArgumentMatchers.any(FeiraDTO.class)))
                .thenReturn(montarFeiraVO());
        Mockito.when(mapper.toFeiraDTORS(ArgumentMatchers.any(FeiraVO.class))).thenReturn(montarFeiraDTORS());

        mockMvc.perform(MockMvcRequestBuilders.put("/feiras/1")
                .content(requestFeira())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson()))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testTentaAtualizarFeiraComErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/feiras/1")
                .content("")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private String requestFeira() throws Exception {

        FeiraDTO feira = new FeiraDTO();

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

        return new ObjectMapper().writeValueAsString(feira);
    }

    private FeiraVO montarFeiraVO() {
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

        return feira;
    }

    private FeiraDTORS montarFeiraDTORS() {
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

        return feira;
    }

    private String responseJson() throws Exception {
        return new ObjectMapper().writeValueAsString(montarFeiraDTORS());
    }

}