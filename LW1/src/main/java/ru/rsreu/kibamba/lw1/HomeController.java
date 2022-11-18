package ru.rsreu.kibamba.lw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rsreu.kibamba.lw1.data.MedicinalHerbDAO;
import ru.rsreu.kibamba.lw1.services.MongoDbSequenceGenerator;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final MedicinalHerbDAO medicinalHerbDAO;
    private final MongoDbSequenceGenerator mongoDbSequenceGenerator;
    @Autowired
    public HomeController(MedicinalHerbDAO medicinalHerbDAO, MongoDbSequenceGenerator mongoDbSequenceGenerator){
        this.medicinalHerbDAO = medicinalHerbDAO;
        this.mongoDbSequenceGenerator = mongoDbSequenceGenerator;
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("medicinalHerbs",medicinalHerbDAO.findAll());
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
        medicinalHerb.setId(mongoDbSequenceGenerator.getSequenceNumber(MedicinalHerb.SEQUENCE));
        medicinalHerbDAO.save(medicinalHerb);
        return "redirect:/";
    }


}
