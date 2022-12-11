package ru.rsreu.kibamba.lw1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rsreu.kibamba.lw1.entity.MedicinalHerb;

@RepositoryRestResource(path = "medicinal-herbs")
public interface MedicinalHerbRepository extends MongoRepository<MedicinalHerb, Integer> {

}
