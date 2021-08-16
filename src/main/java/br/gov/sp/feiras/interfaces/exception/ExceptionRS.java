package br.gov.sp.feiras.interfaces.exception;

import java.time.LocalDateTime;

public class ExceptionRS {

    private final LocalDateTime data;
    private final String mensagem;

    public ExceptionRS(LocalDateTime data, String mensagem) {
        this.data = data;
        this.mensagem = mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getMensagem() {
        return mensagem;
    }

}
