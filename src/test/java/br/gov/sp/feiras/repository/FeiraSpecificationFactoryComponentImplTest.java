package br.gov.sp.feiras.repository;

import br.gov.sp.feiras.application.vo.BuscaFeirasVO;
import br.gov.sp.feiras.entity.Feira;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.data.jpa.domain.Specification;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FeiraSpecificationFactoryComponentImplTest {

    @MethodSource("cenarios")
    @ParameterizedTest
    void testGetSpecification(BuscaFeirasVO buscaFeirasVO) {
        Specification<Feira> specification = new FeiraSpecificationFactoryComponentImpl().getSpecification(buscaFeirasVO);

        assertNotNull(specification, "Specification Não deve ser Null");
    }

    static Stream<Arguments> cenarios() {
        return Stream.of(
                Arguments.of(montarBuscaFeiraVO("", "", "", "")),
                Arguments.of(montarBuscaFeiraVO(null, null, null, null)),
                Arguments.of(montarBuscaFeiraVO("VILA FORMOSA", "", "", "")),
                Arguments.of(montarBuscaFeiraVO("VILA FORMOSA", null, null, null)),
                Arguments.of(montarBuscaFeiraVO("", "VILA FORMOSA", "", "")),
                Arguments.of(montarBuscaFeiraVO(null, "VILA FORMOSA", null, null)),
                Arguments.of(montarBuscaFeiraVO("", "", "VL FORMOSA", "")),
                Arguments.of(montarBuscaFeiraVO(null, null, "VL FORMOSA", null)),
                Arguments.of(montarBuscaFeiraVO("", "", "", "Leste")),
                Arguments.of(montarBuscaFeiraVO(null, null, null, "Leste"))
        );
    }

    static BuscaFeirasVO montarBuscaFeiraVO(String nomeFeira, String distrito, String bairro, String regiao5) {
        BuscaFeirasVO buscaFeirasVO = new BuscaFeirasVO();

        buscaFeirasVO.setNomeFeira(nomeFeira);
        buscaFeirasVO.setDistrito(distrito);
        buscaFeirasVO.setBairro(bairro);
        buscaFeirasVO.setRegiao5(regiao5);

        return buscaFeirasVO;
    }
}