package br.gov.sp.feiras.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:/application-integration-test.properties")
@AutoConfigureMockMvc
public class BuscaFeiraIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testBuscaFeiraPorNomeFeira() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/feiras?nomeFeira=VILA"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        var contentAsString = result.getResponse().getContentAsString();

        var response = new ObjectMapper().readValue(contentAsString, List.class);

        Assertions.assertEquals(2, response.size(), "Quantidade de Elementos Invalido");
    }

    @Test
    void testBuscaFeiraPorBairro() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/feiras?bairro=VL"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        var contentAsString = result.getResponse().getContentAsString();

        var response = new ObjectMapper().readValue(contentAsString, List.class);

        Assertions.assertEquals(3, response.size(), "Quantidade de Elementos Invalido");
    }

    @Test
    void testBuscaFeiraPorRegiao5() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/feiras?regiao5=Sul"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        var contentAsString = result.getResponse().getContentAsString();

        var response = new ObjectMapper().readValue(contentAsString, List.class);

        Assertions.assertEquals(1, response.size(), "Quantidade de Elementos Invalido");
    }

    @Test
    void testBuscaFeiraPorDistrito() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/feiras?distrito=PENHA"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        var contentAsString = result.getResponse().getContentAsString();

        var response = new ObjectMapper().readValue(contentAsString, List.class);

        Assertions.assertEquals(2, response.size(), "Quantidade de Elementos Invalido");
    }

}
