package br.com.senai.tarefas.model.dto;

import br.com.senai.tarefas.model.entidade.StatusTarefa;

public record TarefaResponseListarTarefaDTO(Long id, String titulo, String descricao, StatusTarefa status, Long pessoa_id) {
}
