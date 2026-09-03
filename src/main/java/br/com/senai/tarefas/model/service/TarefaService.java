package br.com.senai.tarefas.model.service;

import br.com.senai.tarefas.exceptions.RecursoNaoEncontradoException;
import br.com.senai.tarefas.model.dto.AtualizarTarefaDTO;
import br.com.senai.tarefas.model.dto.CadastrarTarefaDTO;
import br.com.senai.tarefas.model.dto.TarefaResponseListarTarefaDTO;
import br.com.senai.tarefas.repository.PessoaRepository;
import br.com.senai.tarefas.repository.TarefaRepository;
import br.com.senai.tarefas.model.dto.TarefaResponseDTO;
import br.com.senai.tarefas.model.entidade.StatusTarefa;
import br.com.senai.tarefas.model.entidade.Tarefa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final PessoaRepository pessoaRepository;

    public void cadastrar (CadastrarTarefaDTO cadastrarTarefaDTO) {
        var pessoa = pessoaRepository.findById (cadastrarTarefaDTO.id())
                .orElseThrow(() -> new RecursoNaoEncontradoException("não encontrado"));


        Tarefa novaTarefa = new Tarefa();
        var dataCriacao = LocalDate.now();

        novaTarefa.setPessoa(pessoa);
        novaTarefa.setTitulo(cadastrarTarefaDTO.titulo());
        novaTarefa.setDescricao(cadastrarTarefaDTO.descricao());
        novaTarefa.setStatus(StatusTarefa.PENDENTE);
        novaTarefa.setDataCriacao(dataCriacao);
        pessoa.getTarefas().add(novaTarefa);


        tarefaRepository.save(novaTarefa);


    }

    public void concluir(Long id) {
        var tarefaEncontrada = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa nao encontrada"));

        tarefaEncontrada.setStatus(StatusTarefa.CONCLUIDA);
        tarefaRepository.save(tarefaEncontrada);

    }

    public void excluir(long id) {
        var tarefaEncontrada = tarefaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("tarefa nao encontrada"));

        tarefaRepository.delete(tarefaEncontrada);
    }

    public List<TarefaResponseListarTarefaDTO> listar () {
        return tarefaRepository.findAll()
                .stream()
                .map(this::convertDTO)
                .toList();
    }

    public List<TarefaResponseListarTarefaDTO> listarPorId (Long id) {
        var pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("não encontrado"));

        return tarefaRepository.findById(pessoa.getId())
                .stream()
                .map(this::convertDTO)
                .toList();
    }

    public TarefaResponseListarTarefaDTO convertDTO (Tarefa tarefa) {
        return new TarefaResponseListarTarefaDTO(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getPessoa().getId());
    }

    public void atualizar(AtualizarTarefaDTO atualizarTarefaDTO) {
        var tarefaEncontrada = tarefaRepository.findById(atualizarTarefaDTO.id())
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

    }






}
