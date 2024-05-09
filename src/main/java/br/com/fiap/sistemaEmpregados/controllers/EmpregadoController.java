package br.com.fiap.sistemaEmpregados.controllers;

import br.com.fiap.sistemaEmpregados.dto.DepartamentoDTO;
import br.com.fiap.sistemaEmpregados.dto.EmpregadoDTO;
import br.com.fiap.sistemaEmpregados.dto.ProjetoDTO;
import br.com.fiap.sistemaEmpregados.models.Empregado;
import br.com.fiap.sistemaEmpregados.services.DepartamentoService;
import br.com.fiap.sistemaEmpregados.services.EmpregadoService;
import br.com.fiap.sistemaEmpregados.services.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/empregados")
public class EmpregadoController {

@Autowired
    private EmpregadoService service;

@Autowired
    private DepartamentoService departamentoService;

@Autowired
    private ProjetoService projetoService;

    @ModelAttribute("projetos")
    public List<ProjetoDTO> projetos(){
        return projetoService.findAll();
    }

    @ModelAttribute("departamentos")
    public List<DepartamentoDTO> departamentos() {
        return departamentoService.findAll();
    }

    @GetMapping("/form")
    public String loadFormempregado(Model model) {
        model.addAttribute("empregadoDTO", new Empregado());
        return "empregados/novo-empregado";
    }

    @PostMapping()
    public String insert(@Valid EmpregadoDTO empregadoDTO,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "empregados/novo-empregado";
        }
        empregadoDTO = service.insert(empregadoDTO);
        attributes.addFlashAttribute("mensagem", "Empregado salvo com sucesso");
        return "redirect:/empregados/form";
    }
    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("empregados", service.findAll());
        return "/empregados/listar-empregados";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        EmpregadoDTO empregadoDTO = service.findById(id);
        model.addAttribute("empregadoDTO", empregadoDTO);
        return "/empregados/editar-empregados";
    }
    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid EmpregadoDTO empregadoDTO,
                         BindingResult result) {
        if (result.hasErrors()) {
            empregadoDTO.setId(id);
            return "/empregados/editar-empregados";
        }
        service.update(id, empregadoDTO);
        return "redirect:/empregados";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        return "redirect:/empregados";
    }


}
