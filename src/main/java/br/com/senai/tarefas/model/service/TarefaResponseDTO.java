package br.com.senai.tarefas.model.service;

import br.com.senai.tarefas.model.entidade.StatusTarefa;

public record TarefaResponseDTO(String titulo, String descricao, StatusTarefa status) {
}
