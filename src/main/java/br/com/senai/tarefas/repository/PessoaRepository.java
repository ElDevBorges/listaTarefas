package br.com.senai.tarefas.repository;

import br.com.senai.tarefas.model.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PessoaRepositorya extends JpaRepository<Pessoa, Long> {

}
