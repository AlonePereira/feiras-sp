package br.gov.sp.feiras.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class BuscaFeirasControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BuscaFeirasController()).build();
    }

    @Test
    void testBuscarFeirasComSucesso() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/feiras?nomeFeira=CECILIA ITER"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testBuscarFeirasComErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/feiras"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}