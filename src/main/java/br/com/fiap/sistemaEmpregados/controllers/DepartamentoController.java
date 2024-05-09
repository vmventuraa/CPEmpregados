package br.com.fiap.sistemaEmpregados.controllers;


import br.com.fiap.sistemaEmpregados.dto.DepartamentoDTO;
import br.com.fiap.sistemaEmpregados.models.Departamento;
import br.com.fiap.sistemaEmpregados.services.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;


    @GetMapping("/form")
    public String loadFormDepartamento(Model model) {
        model.addAttribute("departamentoDTO", new DepartamentoDTO());
        return "departamentos/novo-departamento";
    }

    @PostMapping()
    public String insert(@Valid DepartamentoDTO departamentoDTO, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "departamentos/novo-departamento";
        }
        departamentoDTO = service.insert(departamentoDTO);
        attributes.addFlashAttribute("mensagem", "Departamento salvo com sucesso!");
        return "redirect:/departamentos/form";
    }

    @GetMapping()
    public String findAll(Model model) {
        List<DepartamentoDTO> departamentosDTO = service.findAll();
        model.addAttribute("departamentosDTO", departamentosDTO);
        return "/departamentos/listar-departamentos";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        DepartamentoDTO departamentoDTO = service.findById(id);
        model.addAttribute("departamentoDTO", departamentoDTO);
        return "/departamentos/editar-departamentos";
    }
    //@PutMapping("{id}") fui usar o put, mas não estava funcionando junto com o front, com post funciona
    @PostMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid DepartamentoDTO departamentoDTO,
                         BindingResult result) {
        if (result.hasErrors()) {
            departamentoDTO.setId(id);
            return "/departamentos/editar-departamentos";
        }
        service.update(id, departamentoDTO);
        return "redirect:/departamentos";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        return "redirect:/departamentos";
    }
}
