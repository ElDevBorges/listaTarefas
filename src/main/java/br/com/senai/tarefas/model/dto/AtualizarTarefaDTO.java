package br.com.senai.tarefas.model.dto;

import br.com.senai.tarefas.model.entidade.StatusTarefa;

public record AtualizarTarefaDTO (Long id, StatusTarefa statusTarefa){
}
