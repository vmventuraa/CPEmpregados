package br.com.fiap.sistemaEmpregados.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "tb_empregado")
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;


    private String nome;


    private String email;

    private Double salario;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tb_departamento", nullable = false)
    private Departamento departamento;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_empregado_projeto",
            joinColumns = @JoinColumn(name = "empregado_id"),
            inverseJoinColumns = @JoinColumn(name = "projeto_id"))
    private Set<Projeto> projetos = new HashSet<>();

}
