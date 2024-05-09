package br.com.fiap.sistemaEmpregados.dto;

import br.com.fiap.sistemaEmpregados.models.Projeto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProjetoDTO {

    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter mínimo 3 caracteres")
    private String nome;

    public ProjetoDTO(Projeto projeto) {
        id = projeto.getId();
        nome = projeto.getNome();
    }


}
