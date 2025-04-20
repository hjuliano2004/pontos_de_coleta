package pratica.atividade.pontos_de_coleta.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pratica.atividade.pontos_de_coleta.dtos.LixoRequestDto;
import pratica.atividade.pontos_de_coleta.dtos.LixoResponseDto;
import pratica.atividade.pontos_de_coleta.entities.LixoEletronico;
import pratica.atividade.pontos_de_coleta.errors.exceptions.BadRequestException;
import pratica.atividade.pontos_de_coleta.errors.exceptions.LixoNotFoundException;
import pratica.atividade.pontos_de_coleta.mappers.LixoMapper;
import pratica.atividade.pontos_de_coleta.repositories.LixoRepository;

@Service
@RequiredArgsConstructor
public class LixoServiceImpl implements LixoService{

    private final LixoRepository repository;

    @Override
    public List<LixoEletronico> findAll(){
        return repository.findAll();
    }

    @Override
    public List<LixoResponseDto> getAll(){
        List<LixoEletronico> lixos = this.findAll();
        List<LixoResponseDto> list = new ArrayList<>();
        for(LixoEletronico lixo : lixos){

            list.add(LixoMapper.toDto(lixo));
        }

        return list;
    }

    @Override
    public LixoResponseDto findById(Long id){
    LixoEletronico lixo = repository.findById(id).orElseThrow(() ->
     new LixoNotFoundException("registron com id " + id + " não existe"));
    return LixoMapper.toDto(lixo);
    }


    @Override
    public LixoResponseDto create(LixoRequestDto dto){
        validateDto(dto);

        LixoEletronico lixo = new LixoEletronico();
        lixo.setDescricao(dto.descricao());
        lixo.setTipo(dto.tipo());

        lixo = repository.save(lixo);

        return LixoMapper.toDto(lixo);
    }

    @Override
    public void delete(Long id){
       if(!repository.existsById(id)){
        throw new LixoNotFoundException("registron com id " + id + " não deletado ou não existe");
    }
    repository.deleteById(id);
}

    @Override
    public LixoResponseDto atualiza(Long id, LixoRequestDto dto){
        validateDto(dto);
        
        LixoEletronico lixo = repository.findById(id).orElseThrow(()
        -> new LixoNotFoundException("item " + id + " não encontrado"));
            lixo.setDescricao(dto.descricao());
            lixo.setTipo(dto.tipo());
            lixo = repository.save(lixo);
            return LixoMapper.toDto(lixo);   
    }

    private void validateDto(LixoRequestDto dto){
        if(dto.descricao().isEmpty() || dto.tipo().isEmpty()){
            throw new BadRequestException("preenchimento obrigatório");
        }
    }
       
}