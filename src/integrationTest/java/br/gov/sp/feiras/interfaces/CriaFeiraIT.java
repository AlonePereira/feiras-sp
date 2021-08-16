package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import br.gov.sp.feiras.interfaces.dto.FeiraDTORS;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class CriaFeiraIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCriaFeira() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/feiras")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(montaRequest()))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(montaResponse()));
    }

    private String montaRequest() throws Exception {
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

    private String montaResponse() throws Exception {
        FeiraDTORS feira = new FeiraDTORS();

        feira.setId(11L);
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
        feira.setNumero("");

        return new ObjectMapper().writeValueAsString(feira);
    }

}
