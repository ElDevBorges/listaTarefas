package br.com.senai.tarefas.model.dto;

import br.com.senai.tarefas.model.entidade.Tarefa;

import java.util.List;

public record PessoaResponseDTO (Long id, String nome, String email, List <TarefaResponseDTO> tarefas) {
}
