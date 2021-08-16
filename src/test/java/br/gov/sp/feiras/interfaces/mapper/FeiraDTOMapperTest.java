package br.gov.sp.feiras.interfaces.mapper;

import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeiraDTOMapperTest {

    private FeiraDTOMapperImpl mapper;

    @BeforeEach
    void setUp() {
        mapper = new FeiraDTOMapperImpl();
    }

    @Test
    void testSetReferenciaNull() {
        var feiraDTO = new FeiraDTO();
        var feiraVO = new FeiraVO();

        mapper.setReferencia(feiraVO, feiraDTO);

        assertNotNull(feiraVO.getReferencia(), "Referencia Não deveria ser null");
        assertEquals("", feiraVO.getReferencia(), "Referencia deveria ser vazio");
    }

    @Test
    void testSetReferenciaComFeiraDTONull() {
        var feiraVO = new FeiraVO();

        mapper.setReferencia(feiraVO, null);

        assertNotNull(feiraVO.getReferencia(), "Referencia Não deveria ser null");
        assertEquals("", feiraVO.getReferencia(), "Referencia deveria ser vazio");
    }

    @Test
    void testSetReferencia() {
        var feiraDTO = new FeiraDTO();
        feiraDTO.setReferencia("TV RUA PRETORIA");

        var feiraVO = new FeiraVO();

        mapper.setReferencia(feiraVO, feiraDTO);

        assertNotNull(feiraVO.getReferencia(), "Referencia Não deveria ser null");
        assertEquals("TV RUA PRETORIA", feiraVO.getReferencia(), "Valor de Referencia Invalido");
    }

    @Test
    void testSetNumeroNull() {
        var feiraDTO = new FeiraDTO();
        var feiraVO = new FeiraVO();

        mapper.setNumero(feiraVO, feiraDTO);

        assertNotNull(feiraVO.getNumero(), "Numero Não deveria ser null");
        assertEquals("", feiraVO.getNumero(), "Numero deveria ser vazio");
    }

    @Test
    void testSetNumeroComFeiraDTONull() {
        var feiraVO = new FeiraVO();

        mapper.setNumero(feiraVO, null);

        assertNotNull(feiraVO.getNumero(), "Numero Não deveria ser null");
        assertEquals("", feiraVO.getNumero(), "Numero deveria ser vazio");
    }

    @Test
    void testSetNumero() {
        var feiraDTO = new FeiraDTO();
        feiraDTO.setNumero("S/N");

        var feiraVO = new FeiraVO();

        mapper.setNumero(feiraVO, feiraDTO);

        assertNotNull(feiraVO.getNumero(), "Numero Não deveria ser null");
        assertEquals("S/N", feiraVO.getNumero(), "Valor de Numero Invalido");
    }

    @Test
    void testToFeiraVOComIdEFeiraDTONulos() {
        var feiraVO = mapper.toFeiraVO(null, null);

        assertNull(feiraVO, "FeiraVO deveria ser null");
    }

    @Test
    void testToFeiraVOComIdNulo() {
        var feiraDTO = new FeiraDTO();

        feiraDTO.setLat(-46550164D);
        feiraDTO.setLon(-23558733D);
        feiraDTO.setSetcens("355030885000091");
        feiraDTO.setAreaP("3550308005040");
        feiraDTO.setCodDist(87);
        feiraDTO.setDistrito("VILA FORMOSA");
        feiraDTO.setCodigoSubPrefeitura(26);
        feiraDTO.setSubPrefeitura("ARICANDUVA-FORMOSA-CARRAO");
        feiraDTO.setRegiao5("Leste");
        feiraDTO.setRegiao8("Leste 1");
        feiraDTO.setNomeFeira("VILA FORMOSA");
        feiraDTO.setRegistro("4041-0");
        feiraDTO.setLogradouro("RUA MARAGOJIPE");
        feiraDTO.setNumero("S/N");
        feiraDTO.setBairro("VL FORMOSA");
        feiraDTO.setReferencia("TV RUA PRETORIA");

        var feiraVO = mapper.toFeiraVO(null, feiraDTO);

        assertNull(feiraVO.getId(), "Valor do ID deveria ser null");
        assertEquals(feiraDTO.getLat(), feiraVO.getLat(), "Valor da Latitude divergente");
        assertEquals(feiraDTO.getLon(), feiraVO.getLon(), "Valor da Longitude divergente");
        assertEquals(feiraDTO.getSetcens(), feiraVO.getSetcens(), "Valor do Setcens divergente");
        assertEquals(feiraDTO.getAreaP(), feiraVO.getAreaP(), "Valor da AreaP divergente");
        assertEquals(feiraDTO.getCodDist(), feiraVO.getCodDist(), "Valor do CodDist divergente");
        assertEquals(feiraDTO.getDistrito(), feiraVO.getDistrito(), "Valor do Distrito divergente");
        assertEquals(feiraDTO.getCodigoSubPrefeitura(), feiraVO.getCodigoSubPrefeitura(),
                "Valor do CodigoSubPrefeitura divergente");
        assertEquals(feiraDTO.getSubPrefeitura(), feiraVO.getSubPrefeitura(), "Valor da SubPrefeitura divergente");
        assertEquals(feiraDTO.getRegiao5(), feiraVO.getRegiao5(), "Valor da Regiao5 divergente");
        assertEquals(feiraDTO.getRegiao8(), feiraVO.getRegiao8(), "Valor da Regiao8 divergente");
        assertEquals(feiraDTO.getNomeFeira(), feiraVO.getNomeFeira(), "Valor do NomeFeira divergente");
        assertEquals(feiraDTO.getRegistro(), feiraVO.getRegistro(), "Valor do Registro divergente");
        assertEquals(feiraDTO.getLogradouro(), feiraVO.getLogradouro(), "Valor do Logradouro divergente");
        assertEquals(feiraDTO.getNumero(), feiraVO.getNumero(), "Valor do Numero divergente");
        assertEquals(feiraDTO.getBairro(), feiraVO.getBairro(), "Valor do Bairro divergente");
        assertEquals(feiraDTO.getReferencia(), feiraVO.getReferencia(), "Valor da Referencia divergente");
    }

    @Test
    void testToFeiraVOComFeiraDTONull() {
        var feiraVO = mapper.toFeiraVO(1L, null);

        assertEquals(1L, feiraVO.getId(), "Valor do ID divergente");
    }

    @Test
    void testToFeiraVOComIdEFeiraDTOValido() {
        var feiraDTO = new FeiraDTO();

        feiraDTO.setLat(-46550164D);
        feiraDTO.setLon(-23558733D);
        feiraDTO.setSetcens("355030885000091");
        feiraDTO.setAreaP("3550308005040");
        feiraDTO.setCodDist(87);
        feiraDTO.setDistrito("VILA FORMOSA");
        feiraDTO.setCodigoSubPrefeitura(26);
        feiraDTO.setSubPrefeitura("ARICANDUVA-FORMOSA-CARRAO");
        feiraDTO.setRegiao5("Leste");
        feiraDTO.setRegiao8("Leste 1");
        feiraDTO.setNomeFeira("VILA FORMOSA");
        feiraDTO.setRegistro("4041-0");
        feiraDTO.setLogradouro("RUA MARAGOJIPE");
        feiraDTO.setNumero("S/N");
        feiraDTO.setBairro("VL FORMOSA");
        feiraDTO.setReferencia("TV RUA PRETORIA");

        var feiraVO = mapper.toFeiraVO(1L, feiraDTO);

        assertEquals(1L, feiraVO.getId(), "Valor do ID divergente");
        assertEquals(feiraDTO.getLat(), feiraVO.getLat(), "Valor da Latitude divergente");
        assertEquals(feiraDTO.getLon(), feiraVO.getLon(), "Valor da Longitude divergente");
        assertEquals(feiraDTO.getSetcens(), feiraVO.getSetcens(), "Valor do Setcens divergente");
        assertEquals(feiraDTO.getAreaP(), feiraVO.getAreaP(), "Valor da AreaP divergente");
        assertEquals(feiraDTO.getCodDist(), feiraVO.getCodDist(), "Valor do CodDist divergente");
        assertEquals(feiraDTO.getDistrito(), feiraVO.getDistrito(), "Valor do Distrito divergente");
        assertEquals(feiraDTO.getCodigoSubPrefeitura(), feiraVO.getCodigoSubPrefeitura(),
                "Valor do CodigoSubPrefeitura divergente");
        assertEquals(feiraDTO.getSubPrefeitura(), feiraVO.getSubPrefeitura(), "Valor da SubPrefeitura divergente");
        assertEquals(feiraDTO.getRegiao5(), feiraVO.getRegiao5(), "Valor da Regiao5 divergente");
        assertEquals(feiraDTO.getRegiao8(), feiraVO.getRegiao8(), "Valor da Regiao8 divergente");
        assertEquals(feiraDTO.getNomeFeira(), feiraVO.getNomeFeira(), "Valor do NomeFeira divergente");
        assertEquals(feiraDTO.getRegistro(), feiraVO.getRegistro(), "Valor do Registro divergente");
        assertEquals(feiraDTO.getLogradouro(), feiraVO.getLogradouro(), "Valor do Logradouro divergente");
        assertEquals(feiraDTO.getNumero(), feiraVO.getNumero(), "Valor do Numero divergente");
        assertEquals(feiraDTO.getBairro(), feiraVO.getBairro(), "Valor do Bairro divergente");
        assertEquals(feiraDTO.getReferencia(), feiraVO.getReferencia(), "Valor da Referencia divergente");
    }

    @Test
    void testToFeiraDTORSComFeiraVONull() {
        var feiraDTORS = mapper.toFeiraDTORS(null);

        assertNull(feiraDTORS, "FeiraDTORS deveria ser null");
    }

    @Test
    void testToFeiraDTORS() {
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

        var feiraDTORS = mapper.toFeiraDTORS(feiraVO);

        assertEquals(feiraVO.getId(), feiraDTORS.getId(), "Valor do ID divergente");
        assertEquals(feiraVO.getLat(), feiraDTORS.getLat(), "Valor da Latitude divergente");
        assertEquals(feiraVO.getLon(), feiraDTORS.getLon(), "Valor da Longitude divergente");
        assertEquals(feiraVO.getSetcens(), feiraDTORS.getSetcens(), "Valor do Setcens divergente");
        assertEquals(feiraVO.getAreaP(), feiraDTORS.getAreaP(), "Valor da AreaP divergente");
        assertEquals(feiraVO.getCodDist(), feiraDTORS.getCodDist(), "Valor do CodDist divergente");
        assertEquals(feiraVO.getDistrito(), feiraDTORS.getDistrito(), "Valor do Distrito divergente");
        assertEquals(feiraVO.getCodigoSubPrefeitura(), feiraDTORS.getCodigoSubPrefeitura(),
                "Valor do CodigoSubPrefeitura divergente");
        assertEquals(feiraVO.getSubPrefeitura(), feiraDTORS.getSubPrefeitura(), "Valor da SubPrefeitura divergente");
        assertEquals(feiraVO.getRegiao5(), feiraDTORS.getRegiao5(), "Valor da Regiao5 divergente");
        assertEquals(feiraVO.getRegiao8(), feiraDTORS.getRegiao8(), "Valor da Regiao8 divergente");
        assertEquals(feiraVO.getNomeFeira(), feiraDTORS.getNomeFeira(), "Valor do NomeFeira divergente");
        assertEquals(feiraVO.getRegistro(), feiraDTORS.getRegistro(), "Valor do Registro divergente");
        assertEquals(feiraVO.getLogradouro(), feiraDTORS.getLogradouro(), "Valor do Logradouro divergente");
        assertEquals(feiraVO.getNumero(), feiraDTORS.getNumero(), "Valor do Numero divergente");
        assertEquals(feiraVO.getBairro(), feiraDTORS.getBairro(), "Valor do Bairro divergente");
        assertEquals(feiraVO.getReferencia(), feiraDTORS.getReferencia(), "Valor da Referencia divergente");
    }

}