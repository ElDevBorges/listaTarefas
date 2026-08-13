package br.com.senai.tarefas.model.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pessoa")
@Table
public class Pessoa {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 50)
    private String nome;

    @Column (nullable = false, length = 80)
    @Email
    private String email;

    @OneToMany (mappedBy = "pessoa")
    private List<Tarefa> tarefas = new ArrayList<>();
}
