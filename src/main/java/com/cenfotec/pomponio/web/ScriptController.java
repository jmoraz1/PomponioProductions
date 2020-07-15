package com.cenfotec.pomponio.web;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cenfotec.pomponio.domain.FormView;
import com.cenfotec.pomponio.domain.Script;
import com.cenfotec.pomponio.service.ScriptService;
import com.cenfotec.pomponio.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScriptController {
    @Autowired
    ScriptService scriptService;
    @Autowired
    WriterService writerService;

    @RequestMapping("/scripts")
    public String index(Model model) throws ParseException {
        model.addAttribute("script", new Script());
        return "scripts";
    }

    @RequestMapping("/scriptsList")
    public String listScripts(Model model) throws ParseException {
        model.addAttribute("scripts",
                scriptService.getAll());
        model.addAttribute("formView", new FormView());

        return "scriptsList";
    }

    @PostMapping("/scripts")
    public String registerScript(@ModelAttribute Script script, BindingResult bindingResult, Model model) throws ParseException {
        scriptService.save(script);
        model.addAttribute("script", new Script());
        return "scripts";

    }
    @PostMapping("/findScript/genre")
    public String buscarEdad(@ModelAttribute FormView form, BindingResult bindingResult, Model model) throws ParseException {
        model.addAttribute("scripts",scriptService.findByGenre(form.getValues()));
        model.addAttribute("formView", new FormView());
        return "scriptsList";
    }

    @PostMapping("/findScript/name")
    public String buscarNombre(@ModelAttribute FormView form, BindingResult bindingResult, Model model) throws ParseException {
        model.addAttribute("scripts",scriptService.findByName(form.getValues()));
        model.addAttribute("formView", new FormView());

        return "scriptsList";
    }

    @ModelAttribute("generos")
    public Map<String, String> listaGeneros() {
        Map<String, String> generos = new HashMap<String, String>();
        generos.put("Tragedia", "Tragedia");
        generos.put("Comedia", "Comedia");
        generos.put("Culebrón", "Culebrón");
        generos.put("Fantasía", "Fantasía");
        return generos;
    }
    
    @ModelAttribute("writers")
    public List<Object> listaEscritores() {
    
        return writerService.getAll();
    }


    
}
