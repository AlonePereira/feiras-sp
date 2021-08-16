package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.application.delete.DeletaFeiraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class DeletaFeiraControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DeletaFeiraService service;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new DeletaFeiraController(service)).build();
    }

    @Test
    void testDeletaComSucesso() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/feiras/1"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}