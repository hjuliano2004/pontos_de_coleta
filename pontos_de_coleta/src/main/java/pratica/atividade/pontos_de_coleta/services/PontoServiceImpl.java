package pratica.atividade.pontos_de_coleta.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pratica.atividade.pontos_de_coleta.dtos.PontoRequestDto;
import pratica.atividade.pontos_de_coleta.dtos.PontoResponseDto;
import pratica.atividade.pontos_de_coleta.entities.LixoEletronico;
import pratica.atividade.pontos_de_coleta.entities.Ponto;
import pratica.atividade.pontos_de_coleta.mappers.PontoMapper;
import pratica.atividade.pontos_de_coleta.repositories.PontoRepository;
import pratica.atividade.pontos_de_coleta.errors.exceptions.BadRequestException;
import pratica.atividade.pontos_de_coleta.errors.exceptions.FlexNotFoundException;

@Service
@RequiredArgsConstructor
public class PontoServiceImpl implements PontoService{
    
    private final PontoRepository repository;
    private final LixoService lixoService;

    @Override
    public List<Ponto> findAll(String search) {
        List<Ponto> pontos;

        if(search == null || search.isEmpty()){
            pontos = repository.findAll();
        }else{
            pontos = repository.findByLixoEletronicoGetTipo(search);
        }

        List<Ponto> list = new ArrayList<>();

        for(Ponto ponto : pontos){
            list.add(ponto);
        }

        if(list.isEmpty() || list == null){
            throw new FlexNotFoundException("nenhum ponto de coleta foi cadastrado");
        }

    return list;
    }

    @Override
    public List<PontoResponseDto> getAll(String search) {
        List<Ponto> pontos = this.findAll(search);
        List<PontoResponseDto> list = new ArrayList<>();
         for(Ponto ponto : pontos){
            list.add(PontoMapper.toDto(ponto));
         }
         return list;
    }

    @Override
    public Ponto findById(Long id) {
        return repository.findById(id).orElseThrow(()
         -> new FlexNotFoundException("ponto de coleta id " +id + " não encontrado"));
    }

    @Override
    public PontoResponseDto getById(Long id){
        return PontoMapper.toDto(this.findById(id));
    }

    @Override
    public PontoResponseDto create(PontoRequestDto dto) {
        validateDto(dto);

        Ponto ponto = PontoMapper.ToEntity(dto);
        ponto.setLixoEletronico(getLixoEletronico(dto.id_Lixo()));
        ponto = repository.save(ponto);
        return PontoMapper.toDto(ponto);
    }

    @Override
    public PontoResponseDto atualiza(Long id, PontoRequestDto dto) {
        validateDto(dto);

    Ponto ponto = repository.findById(id).orElseThrow(() -> 
        new FlexNotFoundException("ponto id " + id + " inexistente, verifique novamente"));


    ponto.setNome(dto.nome());
    ponto.setEndereco(dto.endereco());
    ponto.setDiaColeta(dto.diaColeta());
    ponto.setLixoEletronico(getLixoEletronico(dto.id_Lixo()));

    ponto = repository.save(ponto);

    return PontoMapper.toDto(ponto);
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new FlexNotFoundException("o ponto não existe ou não foi apagado");
        }
            repository.deleteById(id);
    }


        private LixoEletronico getLixoEletronico(Long id_Lixo) {
        return lixoService.findById(id_Lixo);
    }


        private void validateDto(PontoRequestDto dto){
        if(dto.nome().isEmpty()){
            throw new BadRequestException("preenchimento do nome obrigatório");
        }

        if(dto.endereco().isEmpty()){
            throw new BadRequestException("preenchimento do endereço obrigatório");
        }

        if(dto.id_Lixo() == null){
            throw new BadRequestException("preenchimento do id do lixo obrigatório");
        }

        if(dto.diaColeta().isEmpty()){
            throw new BadRequestException("preenchimento do dia de coleta obrigatório");
        }
    }

}