package br.com.senai.tarefas.model.entidade;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity
public class Tarefa {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String descricao;

    @Column (nullable = false)
    private StatusTarefa status;

    @Column (nullable = false)
    private LocalDateTime dataCriacao;

    public Tarefa () {}

    public void Tarefa(String descricao) {
        this.descricao = descricao;
    }


}
