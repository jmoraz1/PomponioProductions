package com.cenfotec.pomponio.web;
import java.text.ParseException;

import com.cenfotec.pomponio.domain.Script;
import com.cenfotec.pomponio.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScriptController {
    @Autowired
    ScriptService scriptService;

    @RequestMapping("/scripts")
    public String index(Model model) throws ParseException {
        model.addAttribute("script", new Script());
        model.addAttribute("scripts",
                scriptService.getAll());


        return "scripts";
    }

    @PostMapping("/scripts")
    public String registerScript(@ModelAttribute Script script) throws ParseException {

        scriptService.save(script);
        return "scripts";

    }
}
