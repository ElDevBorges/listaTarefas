package br.com.senai.tarefas.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // PERMITE TRATAR EXECEÇOES DE TODOS OS CONTROLADORES DA APLICAÇÃO | NAO EXISTE = 404 NOT FOUND | VAZIA = 404 BAD REQUEST
public class TratadorGlobalException {
    public ResponseEntity <ErroResposta> tratarRecursoNaoEncontrado (RecursoNaoEncontradoException exception, HttpServletRequest request) {
        ErroResposta erro = new ErroResposta (
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    public ResponseEntity<Map<String, String>> tratarValidacao (MethodArgumentNotValidException exception) {
        Map<String, String> erros = new HashMap<>();

        for (FieldError erro : exception.getBindingResult().getFieldErrors()) {
            erros.put(erro.getField(), erro.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
}
