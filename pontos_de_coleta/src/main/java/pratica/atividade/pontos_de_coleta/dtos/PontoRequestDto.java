package pratica.atividade.pontos_de_coleta.dtos;

public record PontoRequestDto (
    String nome,
    String endereco,
    String diaColeta,
    Long id_Lixo
){}