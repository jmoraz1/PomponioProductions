package com.cenfotec.pomponio.web;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cenfotec.pomponio.domain.Writer;
import com.cenfotec.pomponio.service.WriterService;
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
public class WriterController {
    @Autowired
    WriterService writerService;

    @RequestMapping("/writers")
    public String index(Model model) throws ParseException {
        model.addAttribute("writer", new Writer());
        model.addAttribute("writers",
                writerService.getAll());

        return "writers";
    }

    @PostMapping("/writers")
    public String registerWriter(@ModelAttribute Writer writer) throws ParseException {

        writerService.save(writer);
        return "writers";

    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
