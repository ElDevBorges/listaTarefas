package br.com.senai.tarefas.model.entidade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column  (nullable = false)
    private String titulo;

    @Column (nullable = false)
    private String descricao;

    @Column (nullable = false)
    @Enumerated(value = EnumType.STRING)
    private StatusTarefa status;

    @Column (nullable = false)
    private LocalDate dataCriacao;

    public Tarefa () {}

    public void Tarefa(String descricao) {
        this.descricao = descricao;
    }


}
