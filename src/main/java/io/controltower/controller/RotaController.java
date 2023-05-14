package io.controltower.controller;

import io.controltower.entity.Rota;
import io.controltower.entity.enums.Status;
import io.controltower.repository.RotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotasRepository rotasRepository;

    private static final String CADASTRO_VIEW = "CadastroRota";

    @RequestMapping("/novo")
    public ModelAndView Cadastro(){

        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject("todosStatus", Status.values());
        mv.addObject(new Rota());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Rota rota, Errors errors, RedirectAttributes redirectAttributes){
        if(errors.hasErrors()){
            return CADASTRO_VIEW;
        }

        try {
            rotasRepository.save(rota);
            redirectAttributes.addFlashAttribute("mensagem","Rota salva com sucesso!");
            return  "redirect:/rotas/novo";
        }catch(DataIntegrityViolationException e) {
            errors.rejectValue("data",null,"Formato de data inválido");
            return CADASTRO_VIEW;
        }
    }

    @RequestMapping
    public ModelAndView pesquisar(){
        List<Rota> todasRotas = rotasRepository.findAll(Sort.by(Sort.Direction.DESC, "data"));
        ModelAndView mv = new ModelAndView("PesquisaRota");
        mv.addObject("rotas", todasRotas);
        return mv;
    }

    @ModelAttribute("todosStatus")
    public List<Status> todosStatus(){
        return Arrays.asList(Status.values());
    }

    @RequestMapping("{id}")
    public ModelAndView edicao(@PathVariable("id") Long idRota) {
        Rota rota = rotasRepository.getOne(idRota);
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(rota);
        return mv;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
        rotasRepository.deleteById(id);

        attributes.addFlashAttribute("mensagem", "Rota excluída com sucesso!");
        return "redirect:/rotas";
    }
}
