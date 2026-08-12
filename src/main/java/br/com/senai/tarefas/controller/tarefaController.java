package br.com.senai.tarefas.controller;

import br.com.senai.tarefas.model.CadastrarTarefaDTO;
import br.com.senai.tarefas.model.entidade.Tarefa;
import br.com.senai.tarefas.model.service.TarefaResponseDTO;
import br.com.senai.tarefas.model.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/v1/api/tarefas")
public class tarefaController {

    private final TarefaService tarefaService;

    public tarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar (@Valid @RequestBody CadastrarTarefaDTO cadastrarTarefaDTO) {
        tarefaService.cadastrar(cadastrarTarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa cadastrada");
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas () {
        return ResponseEntity.ok(tarefaService.listar());
    }
}
