package br.com.fiap.sistemaEmpregados.services;


import br.com.fiap.sistemaEmpregados.dto.ProjetoDTO;
import br.com.fiap.sistemaEmpregados.models.Projeto;
import br.com.fiap.sistemaEmpregados.repository.ProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository repository;

    @Transactional(readOnly = true)
    public List<ProjetoDTO> findAll(){
        List<Projeto> Projetos = repository.findAll();
        return Projetos.stream().map(ProjetoDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProjetoDTO findById(Long id){
        Projeto entity = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado")
        );
        return new ProjetoDTO(entity);
    }

    @Transactional
    public ProjetoDTO update(Long id, ProjetoDTO dto){

        try{
            Projeto Projeto = repository.getReferenceById(id);
            Projeto.setNome(dto.getNome());
            Projeto = repository.save(Projeto);
            return new ProjetoDTO(Projeto);
        } catch (EntityNotFoundException e){
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id){

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
        try{
            repository.deleteById(id);
        } catch (Exception e){
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    private void copyToIdentity(ProjetoDTO dto, Projeto entity){
        entity.setNome(dto.getNome());
    }
}
