package br.com.senai.tarefas.model;

import br.com.senai.tarefas.model.entidade.Tarefa;
import br.com.senai.tarefas.model.service.TarefaResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {


}
