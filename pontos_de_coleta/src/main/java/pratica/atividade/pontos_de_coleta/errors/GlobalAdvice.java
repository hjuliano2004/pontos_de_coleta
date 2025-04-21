package pratica.atividade.pontos_de_coleta.errors;

import pratica.atividade.pontos_de_coleta.dtos.errors.ErrorResponseDto;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pratica.atividade.pontos_de_coleta.errors.exceptions.NotFoundException;

@ControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handle(Exception e){
        return ResponseEntity.internalServerError().body(
            new ErrorResponseDto(
                "500",
                e.getLocalizedMessage(),
                e.getCause().getLocalizedMessage(),
                e.getClass().getName()
            ));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDto> handle(NoSuchElementException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
        "404",
        e.getLocalizedMessage(),
        e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
        e.getClass().getName()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> exception(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
            "404",
            e.getLocalizedMessage(),
            e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
            e.getClass().getSimpleName()
        ));
    }

}