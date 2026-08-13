package br.com.senai.tarefas.repository;

import br.com.senai.tarefas.model.entidade.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {


}
