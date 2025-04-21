package pratica.atividade.pontos_de_coleta.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pratica.atividade.pontos_de_coleta.dtos.PontoRequestDto;
import pratica.atividade.pontos_de_coleta.dtos.PontoResponseDto;
import pratica.atividade.pontos_de_coleta.services.PontoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("pontos")
public class PontoController {
    
    private final PontoService service;

    @GetMapping
    public List<PontoResponseDto> getAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public PontoResponseDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PontoResponseDto post(@RequestBody PontoRequestDto dto){
        return service.create(dto);
    }

    @PutMapping("{id}")
    public PontoResponseDto update(@PathVariable Long id, @RequestBody PontoRequestDto dto){
        return service.atualiza(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}