package pratica.atividade.pontos_de_coleta.dtos.errors;

public record ErrorResponseDto(
    String code,
    String message,
    String cause,
    String exceptionClassName
){}
