package br.com.senai.tarefas.model.entidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;



}
