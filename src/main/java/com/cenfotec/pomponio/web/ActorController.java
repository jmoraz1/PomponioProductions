package com.cenfotec.pomponio.web;
import java.text.ParseException;

import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActorController {
    @Autowired
    ActorService actorService;

    @RequestMapping("/actors")
    public String index(Model model) throws ParseException {
        model.addAttribute("actors",
                actorService.getAll());
        Actor newEntry = new Actor("Jimena Mora", "fem","07/15/2017",1.67,"normal","cafe","cafe");
        actorService.save(newEntry);
        return "actors";
    }
}
