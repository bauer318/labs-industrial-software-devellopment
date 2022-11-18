package ru.rsreu.kibamba.lw1.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import ru.rsreu.kibamba.lw1.MedicinalHerb;

import java.util.ArrayList;
import java.util.List;

public interface MedicinalHerbDAO extends MongoRepository<MedicinalHerb, Integer> {
   /* private List<MedicinalHerb> medicinalHerbs;
    {
        medicinalHerbs = new ArrayList<>();
        medicinalHerbs.add(new MedicinalHerb(1,"Авра́н лека́рственный"," Авран","Норичниковые","Евразия и Северной Америка"));
        medicinalHerbs.add(new MedicinalHerb(2,"Авра́н лека́рственный"," Авран","Норичниковые","Евразия и Северной Америка"));
        medicinalHerbs.add(new MedicinalHerb(3,"Аденантера павлинья"," Adenanthera","Бобовые","Индия и Австралия"));
        medicinalHerbs.add(new MedicinalHerb(4,"Ба́рхат аму́рский"," Бархат","утовые","Китай и Япония"));
        medicinalHerbs.add(new MedicinalHerb(5,"Бе́дренец большо́й"," Бедренец","Зонтичные","Европа"));
        medicinalHerbs.add(new MedicinalHerb(7,"Водяни́ка чёрная"," Водяника","Вересковые","Европа и Северная Америка"));
    }
    public List<MedicinalHerb> index(){
        return medicinalHerbs;
    }
    public void save(MedicinalHerb medicinalHerb){
        medicinalHerb.setId(medicinalHerbs.size()+1);
        medicinalHerbs.add(medicinalHerb);
    }*/
}
