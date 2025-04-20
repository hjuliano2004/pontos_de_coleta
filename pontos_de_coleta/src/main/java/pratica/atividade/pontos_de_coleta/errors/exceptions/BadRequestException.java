package pratica.atividade.pontos_de_coleta.errors.exceptions;

import java.lang.RuntimeException;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}