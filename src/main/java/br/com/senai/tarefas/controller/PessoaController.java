package br.com.senai.tarefas.controller;

import br.com.senai.tarefas.model.dto.CadastrarPessoaDTO;
import br.com.senai.tarefas.model.dto.CadastrarTarefaDTO;
import br.com.senai.tarefas.model.dto.PessoaResponseDTO;
import br.com.senai.tarefas.model.entidade.Pessoa;
import br.com.senai.tarefas.model.service.PessoaService;
import br.com.senai.tarefas.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaService pessoaService, PessoaRepository pessoaRepository) {
        this.pessoaService = pessoaService;
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pessoa> cadastrar (@Valid @RequestBody CadastrarPessoaDTO cadastrarPessoaDTO) {
        Pessoa pessoaCadastrada = pessoaService.cadastrarPessoa(cadastrarPessoaDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pessoaCadastrada);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> listarPessoa () {
        return ResponseEntity.ok(pessoaService.listarPessoas());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        Pessoa pessoaEncontrada = pessoaService.buscarPorId(id);

        return ResponseEntity.ok(pessoaEncontrada);


    }
}
