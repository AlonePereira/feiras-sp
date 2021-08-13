package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class AtualizaFeiraControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AtualizaFeiraController()).build();
    }

    @Test
    void testAtualizarFeiraComSucesso() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/feira/1")
                .content(requestFeira())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testTentaAtualizarFeiraComErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/feira/1")
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

}