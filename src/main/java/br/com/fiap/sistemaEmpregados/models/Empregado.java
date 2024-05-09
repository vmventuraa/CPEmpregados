package br.com.fiap.sistemaEmpregados.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "tb_empregado")
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;


    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Email(message = "Por favor, insira um email válido")
    private String email;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    private Double salario;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tb_departamento", nullable = false)
    private Departamento departamento;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_empregado_projeto",
            joinColumns = @JoinColumn(name = "empregado_id"),
            inverseJoinColumns = @JoinColumn(name = "projeto_id"))
    private Set<Projeto> projetos =  new HashSet<>();

}
