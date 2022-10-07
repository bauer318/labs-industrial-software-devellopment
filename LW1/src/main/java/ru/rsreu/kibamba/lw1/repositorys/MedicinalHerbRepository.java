package ru.rsreu.kibamba.lw1.repositorys;

import org.springframework.data.repository.CrudRepository;
import ru.rsreu.kibamba.lw1.models.MedicinalHerb;

import java.util.Optional;

public interface MedicinalHerbRepository extends CrudRepository<MedicinalHerb,Integer> {

}
