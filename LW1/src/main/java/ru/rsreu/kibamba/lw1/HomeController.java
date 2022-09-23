package ru.rsreu.kibamba.lw1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @ModelAttribute
    public void addMedicinalHerbToModel(Model model){
        model.addAttribute("medicinalHerbs", MedicinalHerb.getListMedicinalHerb());
    }

}
