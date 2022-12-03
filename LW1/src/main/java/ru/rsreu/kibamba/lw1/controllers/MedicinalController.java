package ru.rsreu.kibamba.lw1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rsreu.kibamba.lw1.properties.logger.Logger;
import ru.rsreu.kibamba.lw1.models.MedicinalHerb;
import ru.rsreu.kibamba.lw1.repositorys.MedicinalHerbRepository;

import javax.validation.Valid;

@Controller
public class MedicinalController {

    private final Logger logger;
    private final MedicinalHerbRepository jdbcMedicinalHerbRepository;

    public MedicinalController(MedicinalHerbRepository jdbcMedicinalHerbRepository, Logger logger){
        this.jdbcMedicinalHerbRepository = jdbcMedicinalHerbRepository;
        this.logger = logger;
    }


    @GetMapping("/medicinal-herb")
    public String home(Model model){
        logger.info("Showing medicinal list page");
        model.addAttribute("medicinalHerbs",jdbcMedicinalHerbRepository.findAll());
        return "medicinalHerb";
    }
    @GetMapping("/new")
    public String newMedicinalHerb(Model model){
        logger.info(("Showing new medicinal herb page"));
        model.addAttribute("medicinalHerb", new MedicinalHerb());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("medicinalHerb") @Valid MedicinalHerb medicinalHerb, Errors errors){
        if(errors.hasErrors()){
            logger.warn("Failed to create a new medicinal herb");
            return "new";
        }
        jdbcMedicinalHerbRepository.save(medicinalHerb);
        return "redirect:/medicinal-herb";
    }


}
