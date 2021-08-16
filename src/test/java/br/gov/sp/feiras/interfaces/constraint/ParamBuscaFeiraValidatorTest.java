package br.gov.sp.feiras.interfaces.constraint;

import br.gov.sp.feiras.interfaces.dto.ParamBuscaFeiras;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ParamBuscaFeiraValidatorTest {

    @Mock
    private ConstraintValidatorContext context;

    @ParameterizedTest
    @MethodSource("cenarios")
    void testSeParamBuscaSaoValidos(ParamBuscaFeiras param, boolean ehValido) {
        ParamBuscaFeiraValidator validator = new ParamBuscaFeiraValidator();

        assertEquals(ehValido, validator.isValid(param, context));
    }

    static Stream<Arguments> cenarios() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of(new ParamBuscaFeiras(), false),
                Arguments.of(montaParam("", "", "", ""), false),
                Arguments.of(montaParam(null, "Leste", null, null), true),
                Arguments.of(montaParam("Sé", "", "", ""), true),
                Arguments.of(montaParam("", "", "", "VILA FORMOSA"), true)
        );
    }

    private static ParamBuscaFeiras montaParam(String bairro, String regiao5, String nomeFeira, String distrito) {
        ParamBuscaFeiras param = new ParamBuscaFeiras();

        param.setBairro(bairro);
        param.setNomeFeira(nomeFeira);
        param.setRegiao5(regiao5);
        param.setDistrito(distrito);

        return param;
    }

}