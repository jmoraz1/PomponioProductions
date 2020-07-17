package com.cenfotec.pomponio.web;
import java.net.SecureCacheResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cenfotec.pomponio.domain.FormView;
import com.cenfotec.pomponio.domain.Script;
import com.cenfotec.pomponio.domain.Writer;
import com.cenfotec.pomponio.service.ActorService;
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
    @Autowired
    ActorService actorService;



    @RequestMapping("/scripts")
    public String index(Model model) throws ParseException {
        model.addAttribute("script", new Script());
        return "scripts";
    }

    @RequestMapping("/scriptsInProduction")
    public String listScriptsOnProduction(Model model) throws ParseException {
      
        return "scriptsInProduction";
    }
    
    @RequestMapping("/scriptsList")
    public String listScripts(Model model) throws ParseException {
        model.addAttribute("scripts",
                scriptService.getAll());
        model.addAttribute("formView", new FormView());
        model.addAttribute("script", new Script());


        return "scriptsList";
    }

    @RequestMapping("/scriptsToProduction")
    public String scriptsInProductino(Model model) throws ParseException {
        model.addAttribute("scripts",
                scriptService.getAll());
        model.addAttribute("formView", new FormView());
        model.addAttribute("script", new Script());


        return "scriptsToProduction";
    }

    @PostMapping("/scripts")
    public String registerScript(@ModelAttribute Script script, BindingResult bindingResult, Model model) throws ParseException {
        scriptService.save(script);
        model.addAttribute("script", new Script());
        return "scripts";

    }
    @PostMapping("/findScript/genre")
    public String buscarEdad(@ModelAttribute FormView form, BindingResult bindingResult, Model model) throws ParseException {
        model.addAttribute("scripts", scriptService.findByGenre(form.getValues()));
        model.addAttribute("formView", new FormView());
        return "scriptsList";
    }

    @PostMapping("/findScript/name")
    public String buscarNombre(@ModelAttribute FormView form, BindingResult bindingResult, Model model) throws ParseException {
        model.addAttribute("scripts", scriptService.findByName(form.getValues()));
        model.addAttribute("formView", new FormView());

        return "scriptsList";
    }

    @PostMapping("/moveToProd")
    public String setearEnProduccion(@ModelAttribute FormView form, BindingResult bindingResult,Model model) throws ParseException {
        Script script=scriptService.findByID(form.values);
        script.status=true;
        scriptService.save(script);

        return "scriptsList";
    }

    @PostMapping("/registerActors")
    public String guardarActores(@ModelAttribute Script script, BindingResult bindingResult,Model model) throws ParseException {

        return "scriptsInProduction";
    }

    @PostMapping("/assignActors")
    public String asignarActores(@ModelAttribute Script script, BindingResult bindingResult,Model model) throws ParseException {
        Script fullScript=scriptService.findByID(script.id+"");
        fullScript.actor=script.actor;
        fullScript.actress=script.actress;
        scriptService.save(fullScript);
        return "home";
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
    	List<Object> list=writerService.getAll();
        return list;
    }
    
    @ModelAttribute("scripts")
    public List<Script> listaScripts() {
        
        return scriptService.getAll();
    }

    @ModelAttribute("actores")
    public List<Script> listaActores() {
        return actorService.findByGender("Masculino");
    }
    @ModelAttribute("actrices")
    public List<Script> listaActrices() {
        return actorService.findByGender("Femenino");
    }

    @ModelAttribute("script")
    public Script assignScript(Script script) {

        return script;
    }

    @ModelAttribute("scriptsSinProduccion")
    public List<Script> listaScriptsSinProd() {
        return scriptService.findByStatus("false");
    }

    @ModelAttribute("scriptsConProduccion")
    public List<Script> listaScriptsConProd() {
        ArrayList<Script> scriptsEnProdSinActores=new ArrayList<>();
        for (Object o:scriptService.findByStatus("true")) {
            if(((Script) o).getActor()==null && ((Script) o).getActress()==null){
                scriptsEnProdSinActores.add((Script) o);
            }
        }
        return scriptsEnProdSinActores;
    }

    @ModelAttribute("scriptsEnProduccion")
    public List<Script> listaScriptsEnProd() {
        ArrayList<Script> scriptsEnProd=new ArrayList<>();
        for (Object o:scriptService.findByStatus("true")) {
            if(((Script) o).getActor()!=null && ((Script) o).getActress()!=null){
                scriptsEnProd.add((Script) o);
            }
        }
        return scriptsEnProd;
    }

    public List<Map<String, String>> mappearGuionEscritor( List<Script> scripts) {
        ArrayList<Map<String, String>> listaGuiones=new ArrayList<>();
        for (Script script: scripts
             ) {
            Map<String, String> datos = new HashMap<String, String>();
            datos.put("ID", Long.toString(script.getId()));
            datos.put("Nombre", script.getName());
            datos.put("Genero", script.getGenre());
            datos.put("IdeaCentral", script.getPlot());
            datos.put("Guionista",script.getWriter().getName());
            datos.put("Status", Boolean.toString(script.getStatus()));
            listaGuiones.add(datos);
        }

        return listaGuiones;
    }





    
}
