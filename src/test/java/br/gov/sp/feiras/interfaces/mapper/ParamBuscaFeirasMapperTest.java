package br.gov.sp.feiras.interfaces.mapper;

import br.gov.sp.feiras.interfaces.dto.ParamBuscaFeiras;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParamBuscaFeirasMapperTest {

    private ParamBuscaFeirasMapperImpl mapper;

    @BeforeEach
    void setUp() {
        mapper = new ParamBuscaFeirasMapperImpl();
    }

    @Test
    void testToBuscaFeirasVOComParamBuscaFeirasNulo() {
        var buscaFeirasVO = mapper.toBuscaFeirasVO(null);

        assertNull(buscaFeirasVO, "BuscaFeiraVO deveria ser nulo");
    }

    @Test
    void testToBuscaFeirasVO() {
        var param = new ParamBuscaFeiras();
        param.setBairro("VL FORMOSA");
        param.setDistrito("VILA FORMOSA");
        param.setRegiao5("Leste");
        param.setNomeFeira("VILA FORMOSA");

        var buscaFeirasVO = mapper.toBuscaFeirasVO(param);

        assertEquals(param.getBairro(), buscaFeirasVO.getBairro(), "Valor de Bairro está invalido");
        assertEquals(param.getDistrito(), buscaFeirasVO.getDistrito(), "Valor de Distrito está invalido");
        assertEquals(param.getRegiao5(), buscaFeirasVO.getRegiao5(), "Valor de Rigiao5 está invalido");
        assertEquals(param.getNomeFeira(), buscaFeirasVO.getNomeFeira(), "Valor de NomeFeira está invalido");
    }

}