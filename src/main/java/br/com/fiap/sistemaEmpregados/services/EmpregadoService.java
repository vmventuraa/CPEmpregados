package br.com.fiap.sistemaEmpregados.services;

import br.com.fiap.sistemaEmpregados.dto.EmpregadoDTO;
import br.com.fiap.sistemaEmpregados.models.Empregado;
import br.com.fiap.sistemaEmpregados.models.Projeto;
import br.com.fiap.sistemaEmpregados.repository.EmpregadoRepository;
import br.com.fiap.sistemaEmpregados.repository.ProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository repository;

    @Autowired
    private ProjetoRepository projetoRepository;


    @Transactional(readOnly = true)
    public List<EmpregadoDTO> findAll() {
        List<Empregado> empregados = repository.findAll();

        return empregados.stream()
                .map(EmpregadoDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public EmpregadoDTO insert(EmpregadoDTO dto) {
        Empregado entity = new Empregado();
        copyToEntity(dto, entity);
        entity = repository.save(entity);
        return new EmpregadoDTO(entity);
    }

    @Transactional(readOnly = true)
    public EmpregadoDTO findById(Long id) {

        Empregado empregado = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return new EmpregadoDTO(empregado);
    }

    @Transactional
    public EmpregadoDTO update(Long id, EmpregadoDTO entity) {
        try {
            Empregado empregado = repository.getReferenceById(id);
            copyToEntity(entity, empregado);
            empregado = repository.save(empregado);
            return new EmpregadoDTO(empregado);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Empregado não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Empregado não encontrado - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Empregado designado - id: " + id);
        }
    }


    private void copyToEntity(EmpregadoDTO dto, Empregado entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setSalario(dto.getSalario());
        entity.setDepartamento(dto.getDepartamento());

        entity.getProjetos().clear();
        for (Projeto item : dto.getProjetos()) {
            Projeto projeto = projetoRepository.getReferenceById(item.getId());
            entity.getProjetos().add(projeto);
        }


    }
}
