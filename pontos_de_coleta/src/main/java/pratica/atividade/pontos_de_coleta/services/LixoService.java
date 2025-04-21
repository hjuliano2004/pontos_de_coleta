package pratica.atividade.pontos_de_coleta.services;

import java.util.List;

import pratica.atividade.pontos_de_coleta.dtos.LixoRequestDto;
import pratica.atividade.pontos_de_coleta.dtos.LixoResponseDto;
import pratica.atividade.pontos_de_coleta.entities.LixoEletronico;

public interface LixoService {

    public List<LixoEletronico> findAll();

    public List<LixoResponseDto> getAll();

    public LixoEletronico findById(Long id);

    public LixoResponseDto getById(Long id);

    public LixoResponseDto create(LixoRequestDto dto);

    public void delete(Long id);

    public LixoResponseDto atualiza(Long id, LixoRequestDto dto);
    
}