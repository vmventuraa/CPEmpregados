package br.com.fiap.sistemaEmpregados.dto;


import br.com.fiap.sistemaEmpregados.models.Departamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DepartamentoDTO {

    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 2, message = "O nome deve ter mínimo 2 caracteres")
    private String nome;

    public DepartamentoDTO(Departamento departamento) {
        id = departamento.getId();
        nome = departamento.getNome();
    }


}
