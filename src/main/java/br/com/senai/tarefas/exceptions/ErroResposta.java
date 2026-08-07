package br.com.senai.tarefas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErroResposta {
    private LocalDateTime dataHora;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
