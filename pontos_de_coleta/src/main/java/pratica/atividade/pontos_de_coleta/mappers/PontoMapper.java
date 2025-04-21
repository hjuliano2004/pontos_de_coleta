package pratica.atividade.pontos_de_coleta.mappers;

import pratica.atividade.pontos_de_coleta.dtos.PontoRequestDto;
import pratica.atividade.pontos_de_coleta.dtos.PontoResponseDto;
import pratica.atividade.pontos_de_coleta.entities.Ponto;

public class PontoMapper {
    private PontoMapper(){}

    public static Ponto ToEntity(PontoRequestDto dto){
        Ponto ponto = new Ponto();
        ponto.setNome(dto.nome());
        ponto.setEndereco(dto.endereco());
        ponto.setDiaColeta(dto.diaColeta());
            return ponto;
        }

    public static PontoResponseDto toDto(Ponto ponto){
        return new PontoResponseDto(
        ponto.getId(),
        ponto.getNome(),
        ponto.getEndereco(),
        ponto.getDiaColeta(),
        LixoMapper.toDto(ponto.getLixoEletronico()));
        }

    }
