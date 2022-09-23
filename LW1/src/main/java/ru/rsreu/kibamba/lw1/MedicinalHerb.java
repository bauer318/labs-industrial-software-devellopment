package ru.rsreu.kibamba.lw1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MedicinalHerb {
    private final String name;
    private final String genusType;
    private final String family;
    private final String distribution;

    public  static List<MedicinalHerb> getListMedicinalHerb(){
        List<MedicinalHerb> result = new ArrayList<>();
        result.add(new MedicinalHerb("Авра́н лека́рственный"," Авран","Норичниковые","Евразия и Северной Америка"));
        result.add(new MedicinalHerb("Аденантера павлинья"," Adenanthera","Бобовые","Индия и Австралия"));
        result.add(new MedicinalHerb("Ба́рхат аму́рский"," Бархат","утовые","Китай и Япония"));
        result.add(new MedicinalHerb("Бе́дренец большо́й"," Бедренец","Зонтичные","Европа"));
        result.add(new MedicinalHerb("Водяни́ка чёрная"," Водяника","Вересковые","Европа и Северная Америка"));
        return result;
    }

}
