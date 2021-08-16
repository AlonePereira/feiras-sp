package br.gov.sp.feiras.interfaces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@TestPropertySource(locations = "classpath:/application-integration-test.properties")
@AutoConfigureMockMvc
public class DeleteFeiraIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDeletarFeiraComSucesso() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/feiras/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testTentarDeletarFeiraInexistente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/feiras/11"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

}
