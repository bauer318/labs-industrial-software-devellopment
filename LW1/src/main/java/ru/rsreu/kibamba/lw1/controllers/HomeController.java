package ru.rsreu.kibamba.lw1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rsreu.kibamba.lw1.jdbcrepository.JdbcMedicinalHerbRepository;
import ru.rsreu.kibamba.lw1.models.MedicinalHerb;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final JdbcMedicinalHerbRepository jdbcMedicinalHerbRepository;

    public HomeController(JdbcMedicinalHerbRepository jdbcMedicinalHerbRepository){
        this.jdbcMedicinalHerbRepository = jdbcMedicinalHerbRepository;
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("medicinalHerbs",jdbcMedicinalHerbRepository.findAll());
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
        jdbcMedicinalHerbRepository.save(medicinalHerb);
        return "redirect:/";
    }


}
