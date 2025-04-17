package pratica.atividade.pontos_de_coleta.dtos;

import pratica.atividade.pontos_de_coleta.entities.MateriaisPonto;
import pratica.atividade.pontos_de_coleta.entities.LixoEletronico;
import java.util.List;

public record PontoRequestDto(
    String nome,
    String endereco,
    String diaColeta,
    MateriaisPonto materiaisPonto,
    List<LixoEletronico> lixo
)
 {}
