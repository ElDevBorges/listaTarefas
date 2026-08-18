package br.com.senai.tarefas.model.service;

import br.com.senai.tarefas.exceptions.RecursoNaoEncontradoException;
import br.com.senai.tarefas.model.dto.AtualizarPessoaDTO;
import br.com.senai.tarefas.model.dto.CadastrarPessoaDTO;
import br.com.senai.tarefas.model.dto.PessoaResponseDTO;
import br.com.senai.tarefas.model.dto.TarefaResponseDTO;
import br.com.senai.tarefas.model.entidade.Pessoa;
import br.com.senai.tarefas.model.entidade.Tarefa;
import br.com.senai.tarefas.repository.PessoaRepository;
import br.com.senai.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final TarefaRepository tarefaRepository;
    private final TarefaService tarefaService;

    public PessoaService (PessoaRepository pessoaRepository, TarefaRepository tarefaRepository, TarefaService tarefaService) {
        this.pessoaRepository = pessoaRepository;
        this.tarefaRepository = tarefaRepository;
        this.tarefaService = tarefaService;
    }

    public Pessoa cadastrarPessoa (CadastrarPessoaDTO cadastrarPessoaDTO) {
        Pessoa novaPessoa = new Pessoa();

        novaPessoa.setEmail(cadastrarPessoaDTO.email());
        novaPessoa.setNome(cadastrarPessoaDTO.nome());

        return pessoaRepository.save(novaPessoa);
    }

    public List<PessoaResponseDTO> listarPessoas () {
        return pessoaRepository.findAll()
                .stream()
                .map(this::convertDTO)
                .toList();
    }

    private PessoaResponseDTO convertDTO (Pessoa pessoa){

        return new PessoaResponseDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTarefas());

    }

    tarefaService.
    public void atualizar(Long id, AtualizarPessoaDTO atualizarPessoaDTO) {
        var pessoaEncontrada = pessoaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException ("Não encontrado"));

        pessoaEncontrada.setNome(atualizarPessoaDTO.nome());
        pessoaEncontrada.setEmail(atualizarPessoaDTO.email());

        pessoaRepository.save(pessoaEncontrada);
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow (() -> new RecursoNaoEncontradoException("Não encontrado"));
    }
}