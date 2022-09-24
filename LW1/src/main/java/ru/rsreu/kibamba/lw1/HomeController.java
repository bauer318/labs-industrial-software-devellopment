package ru.rsreu.kibamba.lw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final MedicinalHerbDAO medicinalHerbDAO;

    public HomeController(MedicinalHerbDAO medicinalHerbDAO){
        this.medicinalHerbDAO = medicinalHerbDAO;
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("medicinalHerbs",medicinalHerbDAO.index());
        return "home";
    }
    @GetMapping("/new")
    public String newMedicinalHerb(Model model){
        model.addAttribute("medicinalHerb", new MedicinalHerb());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("medicinalHerb") @Valid MedicinalHerb medicinalHerb, Errors errors){
        if(errors.hasErrors()){
            return "new";
        }
        medicinalHerbDAO.save(medicinalHerb);
        return "redirect:/";
    }


}
