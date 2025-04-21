package pratica.atividade.pontos_de_coleta.errors.exceptions;

public abstract class NotFoundException extends RuntimeException{
    public NotFoundException(String mensagem){
        super(mensagem);
    }
}
