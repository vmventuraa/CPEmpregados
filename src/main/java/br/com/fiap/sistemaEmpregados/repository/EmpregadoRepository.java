package br.com.fiap.sistemaEmpregados.repository;

import br.com.fiap.sistemaEmpregados.models.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
}
