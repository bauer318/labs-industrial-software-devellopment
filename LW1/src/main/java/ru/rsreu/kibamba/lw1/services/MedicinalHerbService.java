package ru.rsreu.kibamba.lw1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rsreu.kibamba.lw1.entity.MedicinalHerb;
import ru.rsreu.kibamba.lw1.repository.MedicinalHerbRepository;

import java.util.List;

@Service
public class MedicinalHerbService {

    private final MedicinalHerbRepository medicinalHerbRepository;
    @Autowired
    public MedicinalHerbService(MedicinalHerbRepository medicinalHerbRepository){
        this.medicinalHerbRepository = medicinalHerbRepository;
    }
    public List<MedicinalHerb> getAllMedicinalHerbs(){
        return medicinalHerbRepository.findAll();
    }
}