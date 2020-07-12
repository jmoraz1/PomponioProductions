package com.cenfotec.pomponio.web;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActorController {
    @Autowired
    ActorService actorService;
    
    @RequestMapping("/actors")
	public String index(Model model) throws ParseException {
    	model.addAttribute("actor", new Actor()); 
		model.addAttribute("actors",
				actorService.getAll());
		
	
		return "actors";
	}
    
    @PostMapping("/actors")
    public String registerActor(@ModelAttribute Actor actor) throws ParseException {
        actorService.save(actor);
        return "actors";
 
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
