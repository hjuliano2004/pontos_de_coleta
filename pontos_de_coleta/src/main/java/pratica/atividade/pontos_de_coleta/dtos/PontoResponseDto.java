package pratica.atividade.pontos_de_coleta.dtos;


public record PontoResponseDto (
    Long id,
    String nome,
    String endereco,
    String diaColeta,
    LixoResponseDto dto
){}