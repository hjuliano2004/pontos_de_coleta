package pratica.atividade.pontos_de_coleta.mappers;

import pratica.atividade.pontos_de_coleta.dtos.LixoRequestDto;
import pratica.atividade.pontos_de_coleta.dtos.LixoResponseDto;
import pratica.atividade.pontos_de_coleta.entities.LixoEletronico;

public class LixoMapper {
    private LixoMapper(){};

    public static LixoEletronico toEntity(LixoRequestDto dto){

        LixoEletronico lixo = new LixoEletronico();
        lixo.setDescricao(dto.descricao());
        lixo.setTipo(dto.tipo());

        return lixo;
    }

    public static LixoResponseDto toDto(LixoEletronico lixo){
        return new LixoResponseDto(lixo.getId(), lixo.getTipo(), lixo.getDescricao());
    }
    
}
