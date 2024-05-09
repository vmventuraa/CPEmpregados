package br.com.fiap.sistemaEmpregados.dto;

import br.com.fiap.sistemaEmpregados.models.Departamento;
import br.com.fiap.sistemaEmpregados.models.Empregado;
import br.com.fiap.sistemaEmpregados.models.Projeto;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpregadoDTO {

    @EqualsAndHashCode.Include
    private Long id;


    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Email(message = "Por favor, insira um email válido")
    private String email;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor do salário deve ser positivo")

    private Double salario;


    private Departamento departamento;


    private List<Projeto> projetos = new ArrayList<>();

    public EmpregadoDTO(Empregado empregado) {
        id = empregado.getId();
        nome = empregado.getNome();
        email = empregado.getEmail();
        salario = empregado.getSalario();
        departamento = empregado.getDepartamento();
        for (Projeto projeto : empregado.getProjetos()) {
            projetos.add(projeto);
        }
    }
}
