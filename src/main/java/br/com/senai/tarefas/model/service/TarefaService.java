package br.com.senai.tarefas.model.service;

import br.com.senai.tarefas.model.CadastrarTarefaDTO;
import br.com.senai.tarefas.model.TarefaRepository;
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

    public void cadastrar (CadastrarTarefaDTO cadastrarTarefaDTO) {
        Tarefa novaTarefa = new Tarefa();
        var dataCriacao = LocalDate.now();

        novaTarefa.setTitulo(cadastrarTarefaDTO.titulo());
        novaTarefa.setDescricao(cadastrarTarefaDTO.descricao());
        novaTarefa.setStatus(StatusTarefa.PENDENTE);
        novaTarefa.setDataCriacao(dataCriacao);

        tarefaRepository.save(novaTarefa);


    }

    public void concluir(Long id) {
        var tarefaEncontrada = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa nao encontrada"));

        tarefaEncontrada.setStatus(StatusTarefa.CONCLUIDA);
        tarefaRepository.save(tarefaEncontrada);

    }

    public List<Tarefa> listar (long id) {
        List <Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas;

    }




}
