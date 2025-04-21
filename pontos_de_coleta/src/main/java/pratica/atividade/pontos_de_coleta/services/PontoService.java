package pratica.atividade.pontos_de_coleta.services;

import java.util.List;

import pratica.atividade.pontos_de_coleta.dtos.PontoRequestDto;
import pratica.atividade.pontos_de_coleta.dtos.PontoResponseDto;
import pratica.atividade.pontos_de_coleta.entities.Ponto;

public interface PontoService {
    
    public List<Ponto> findAll(String search);

    public List<PontoResponseDto> getAll(String search);

    public Ponto findById(Long id);

    public PontoResponseDto getById(Long id);

    public PontoResponseDto create(PontoRequestDto dto);

    public PontoResponseDto atualiza(Long id, PontoRequestDto dto);

    public void delete(Long id);
}
