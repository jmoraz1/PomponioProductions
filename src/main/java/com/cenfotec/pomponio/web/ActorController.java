package com.cenfotec.pomponio.web;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cenfotec.pomponio.domain.FormView;
import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActorController {
    @Autowired
    ActorService actorService;

    List<Actor> actors;
    
    @RequestMapping("/actors")
	public String index(Model model) throws ParseException {
    	model.addAttribute("actor", new Actor());
        model.addAttribute("formView", new FormView());
		model.addAttribute("maleActors",actorService.findByGender("M"));
        model.addAttribute("actors",actorService.getAll());
      
        return "actors";

	}
    @PostMapping("/findActor/age")
    public String buscarEdad(@ModelAttribute FormView form,BindingResult bindingResult, Model model) throws ParseException {
        model.addAttribute("actor", new Actor());

        return "actors";
    }

    @PostMapping("/findActor/name")
    public String buscarNombre(@ModelAttribute FormView form, BindingResult bindingResult, Model model) throws ParseException {
        model.addAttribute("actor", new Actor());
        model.addAttribute("actors",actorService.findByName(form.getValues()));
        return "actors";
    }
    @PostMapping("/actors")
    public String registerActor(@ModelAttribute Actor actor, BindingResult bindingResult, Model model) throws ParseException {
        actorService.save(actor);
        model.addAttribute("formView", new FormView());
        model.addAttribute("actors",actorService.getAll());
        return "actors";

    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    @ModelAttribute("generos")
    public Map<String, String> listaGeneros() {
        Map<String, String> generos = new HashMap<String, String>();
        generos.put("F", "Femenino");
        generos.put("M", "Masculino");
        generos.put("O", "Otro");
        return generos;
    }

}
