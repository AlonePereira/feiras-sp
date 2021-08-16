package br.gov.sp.feiras.application.exception;

public class FeiraNotFound extends RuntimeException {

    public FeiraNotFound(String mensagem) {
        super(mensagem);
    }
}
