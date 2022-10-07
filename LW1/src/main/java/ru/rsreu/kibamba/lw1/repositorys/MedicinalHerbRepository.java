package ru.rsreu.kibamba.lw1.repositorys;

import ru.rsreu.kibamba.lw1.models.MedicinalHerb;

import java.util.Optional;

public interface MedicinalHerbRepository {
    Iterable<MedicinalHerb> findAll();
    Optional<MedicinalHerb> findById(int id);
    MedicinalHerb save(MedicinalHerb medicinalHerb);
}
