package br.com.mslogisticaentrega.application.controller.exceptions;

public class JaCadastradoException extends RuntimeException {
    public JaCadastradoException(String message) {
        super(message);
    }

    public JaCadastradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
