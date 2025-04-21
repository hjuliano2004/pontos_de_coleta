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
import pratica.atividade.pontos_de_coleta.dtos.LixoRequestDto;
import pratica.atividade.pontos_de_coleta.dtos.LixoResponseDto;
import pratica.atividade.pontos_de_coleta.services.LixoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("lixoEletronico")
public class LixoControler {

    private final LixoService service;

    @GetMapping
    public List<LixoResponseDto> get(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public LixoResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LixoResponseDto post(@RequestBody LixoRequestDto dto){
        return service.create(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public LixoResponseDto update(@PathVariable Long id, @RequestBody LixoRequestDto dto){
        return service.atualiza(id, dto);
    }
}