package br.gov.sp.feiras.interfaces.exception;

import br.gov.sp.feiras.application.exception.FeiraNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FeiraNotFound.class)
    public ResponseEntity<Object> handleFeiraNotFound(FeiraNotFound ex) {
        return this.handeExceptions(ex, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        var body = new LinkedHashMap<>();
        body.put("data", LocalDateTime.now());
        body.put("status", status);

        var errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("erros", errors);

        return ResponseEntity.status(status).headers(headers).body(body);
    }

    private ResponseEntity<Object> handeExceptions(Throwable ex, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(new ExceptionRS(LocalDateTime.now(), ex.getMessage()));
    }

}
