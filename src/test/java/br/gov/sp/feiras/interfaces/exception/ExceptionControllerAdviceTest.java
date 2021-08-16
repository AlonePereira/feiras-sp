package br.gov.sp.feiras.interfaces.exception;

import br.gov.sp.feiras.application.exception.FeiraNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExceptionControllerAdviceTest {

    @Test
    void testHandleFeiraNotFound() {
        var ex = new FeiraNotFound("Feira não encontrada");
        var entity = new ExceptionControllerAdvice().handleFeiraNotFound(ex);

        var body = (ExceptionRS) entity.getBody();
        assertNotNull(body, "Body não deveria ser nulo");
        assertNotNull(body.getData(), "Data Não deveria ser nulo");
        assertEquals("Feira não encontrada", body.getMensagem(), "Mensagem divergente");
    }

    @Test
    void testHandleMethodArgumentNotValid() {
        var latError = new FieldError("FeiraDTO", "lat", "lat é Obrigatório");
        var distritoError = new FieldError("FeiraDTO", "distrito",
                "distrito é Obrigatório");

        var bindingResult = Mockito.mock(BindingResult.class);
        var ex = new MethodArgumentNotValidException(null, bindingResult);

        Mockito.when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(latError, distritoError));

        var entity = new ExceptionControllerAdvice().handleMethodArgumentNotValid(ex, null,
                HttpStatus.BAD_REQUEST, null);

        var error = (Map<String, Object>) entity.getBody();
        assertNotNull(error, "Lista de erros deveria não ser Nula");
        assertNotNull(error.get("data"), "Data não deveria ser nulo");
        assertEquals(HttpStatus.BAD_REQUEST, error.get("status"), "Status deveria ser 400");

        var erros = (List<String>) error.get("erros");
        assertNotNull(erros, "Erros não deveria ser nulo");
        assertEquals(2, erros.size(), "Deveria ter 2 erros");
        assertEquals("lat é Obrigatório", erros.get(0), "Mensagem divergente");
        assertEquals("distrito é Obrigatório", erros.get(1), "Mensagem divergente");
    }

}