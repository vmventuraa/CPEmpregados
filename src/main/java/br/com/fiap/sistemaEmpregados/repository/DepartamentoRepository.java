package br.com.fiap.sistemaEmpregados.repository;

import br.com.fiap.sistemaEmpregados.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
