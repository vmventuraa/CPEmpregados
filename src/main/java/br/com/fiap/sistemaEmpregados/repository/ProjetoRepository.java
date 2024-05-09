package br.com.fiap.sistemaEmpregados.repository;

import br.com.fiap.sistemaEmpregados.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
