package br.gov.sp.feiras.application.mapper;

import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.entity.Feira;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FeiraVOMapperTest {

    private FeiraVOMapperImpl mapper;

    @BeforeEach
    void setUp() {
        mapper = new FeiraVOMapperImpl();
    }

    @Test
    void testToFeiraVO() {
        var feira = new Feira();

        feira.setId(1L);
        feira.setLat(-46550164D);
        feira.setLon(-23558733D);
        feira.setSetcens("355030885000091");
        feira.setAreaP("3550308005040");
        feira.setCodDist(87);
        feira.setDistrito("VILA FORMOSA");
        feira.setCodigoSubPrefeitura(26);
        feira.setSubPrefeitura("ARICANDUVA-FORMOSA-CARRAO");
        feira.setRegiao5("Leste");
        feira.setRegiao8("Leste 1");
        feira.setNomeFeira("VILA FORMOSA");
        feira.setRegistro("4041-0");
        feira.setLogradouro("RUA MARAGOJIPE");
        feira.setNumero("S/N");
        feira.setBairro("VL FORMOSA");
        feira.setReferencia("TV RUA PRETORIA");

        var feiraVO = mapper.toFeiraVO(feira);

        assertEquals(feira.getId(), feiraVO.getId(), "Valor do ID divergente");
        assertEquals(feira.getLat(), feiraVO.getLat(), "Valor da Latitude divergente");
        assertEquals(feira.getLon(), feiraVO.getLon(), "Valor da Longitude divergente");
        assertEquals(feira.getSetcens(), feiraVO.getSetcens(), "Valor do Setcens divergente");
        assertEquals(feira.getAreaP(), feiraVO.getAreaP(), "Valor da AreaP divergente");
        assertEquals(feira.getCodDist(), feiraVO.getCodDist(), "Valor do CodDist divergente");
        assertEquals(feira.getDistrito(), feiraVO.getDistrito(), "Valor do Distrito divergente");
        assertEquals(feira.getCodigoSubPrefeitura(), feiraVO.getCodigoSubPrefeitura(),
                "Valor do CodigoSubPrefeitura divergente");
        assertEquals(feira.getSubPrefeitura(), feiraVO.getSubPrefeitura(), "Valor da SubPrefeitura divergente");
        assertEquals(feira.getRegiao5(), feiraVO.getRegiao5(), "Valor da Regiao5 divergente");
        assertEquals(feira.getRegiao8(), feiraVO.getRegiao8(), "Valor da Regiao8 divergente");
        assertEquals(feira.getNomeFeira(), feiraVO.getNomeFeira(), "Valor do NomeFeira divergente");
        assertEquals(feira.getRegistro(), feiraVO.getRegistro(), "Valor do Registro divergente");
        assertEquals(feira.getLogradouro(), feiraVO.getLogradouro(), "Valor do Logradouro divergente");
        assertEquals(feira.getNumero(), feiraVO.getNumero(), "Valor do Numero divergente");
        assertEquals(feira.getBairro(), feiraVO.getBairro(), "Valor do Bairro divergente");
        assertEquals(feira.getReferencia(), feiraVO.getReferencia(), "Valor da Referencia divergente");
    }

    @Test
    void testToFeiraVONull() {
        var feiraVO = mapper.toFeiraVO(null);

        assertNull(feiraVO, "FeiraVO deveria ser nulo");
    }

    @Test
    void testToFeira() {
        var feiraVO = new FeiraVO();

        feiraVO.setId(1L);
        feiraVO.setLat(-46550164D);
        feiraVO.setLon(-23558733D);
        feiraVO.setSetcens("355030885000091");
        feiraVO.setAreaP("3550308005040");
        feiraVO.setCodDist(87);
        feiraVO.setDistrito("VILA FORMOSA");
        feiraVO.setCodigoSubPrefeitura(26);
        feiraVO.setSubPrefeitura("ARICANDUVA-FORMOSA-CARRAO");
        feiraVO.setRegiao5("Leste");
        feiraVO.setRegiao8("Leste 1");
        feiraVO.setNomeFeira("VILA FORMOSA");
        feiraVO.setRegistro("4041-0");
        feiraVO.setLogradouro("RUA MARAGOJIPE");
        feiraVO.setNumero("S/N");
        feiraVO.setBairro("VL FORMOSA");
        feiraVO.setReferencia("TV RUA PRETORIA");

        var feira = mapper.toFeira(feiraVO);

        assertEquals(feiraVO.getId(), feira.getId(), "Valor do ID divergente");
        assertEquals(feiraVO.getLat(), feira.getLat(), "Valor da Latitude divergente");
        assertEquals(feiraVO.getLon(), feira.getLon(), "Valor da Longitude divergente");
        assertEquals(feiraVO.getSetcens(), feira.getSetcens(), "Valor do Setcens divergente");
        assertEquals(feiraVO.getAreaP(), feira.getAreaP(), "Valor da AreaP divergente");
        assertEquals(feiraVO.getCodDist(), feira.getCodDist(), "Valor do CodDist divergente");
        assertEquals(feiraVO.getDistrito(), feira.getDistrito(), "Valor do Distrito divergente");
        assertEquals(feiraVO.getCodigoSubPrefeitura(), feira.getCodigoSubPrefeitura(),
                "Valor do CodigoSubPrefeitura divergente");
        assertEquals(feiraVO.getSubPrefeitura(), feira.getSubPrefeitura(), "Valor da SubPrefeitura divergente");
        assertEquals(feiraVO.getRegiao5(), feira.getRegiao5(), "Valor da Regiao5 divergente");
        assertEquals(feiraVO.getRegiao8(), feira.getRegiao8(), "Valor da Regiao8 divergente");
        assertEquals(feiraVO.getNomeFeira(), feira.getNomeFeira(), "Valor do NomeFeira divergente");
        assertEquals(feiraVO.getRegistro(), feira.getRegistro(), "Valor do Registro divergente");
        assertEquals(feiraVO.getLogradouro(), feira.getLogradouro(), "Valor do Logradouro divergente");
        assertEquals(feiraVO.getNumero(), feira.getNumero(), "Valor do Numero divergente");
        assertEquals(feiraVO.getBairro(), feira.getBairro(), "Valor do Bairro divergente");
        assertEquals(feiraVO.getReferencia(), feira.getReferencia(), "Valor da Referencia divergente");
    }

    @Test
    void testToFeiraNull() {
        var feira = mapper.toFeira(null);

        assertNull(feira, "Feira deveria ser nulo");
    }

    @Test
    void testToFeiraVOList() {
        var feiraVOList = mapper.toFeiraVOList(Collections.singletonList(new Feira()));

        assertNotNull(feiraVOList, "Lista de FeiraVO Não deveria ser Null");
        assertFalse(feiraVOList.isEmpty(), "Lista de FeiraVO Não deveria ser Vazia");
        assertEquals(1, feiraVOList.size(), "Lista de FeiraVO deveria conter 1 elemento");
    }

    @Test
    void testToFeiraVOListNull() {
        var feiraVOList = mapper.toFeiraVOList(null);

        assertNull(feiraVOList, "FeiraVOList deveria ser nulo");
    }

}