package ru.rsreu.kibamba.lw1;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Document(collection = "MedicinalHerb")
public class MedicinalHerb {
    public static final String SEQUENCE = "medicinal_herb_sequence";
    @Id
    private  int id;
    @NotEmpty(message="Название травы не должно быть пустым")
    @Pattern(regexp = "[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9_]*",message = "Название должно начиать с буквой")
    @Size(min=5,max=15,message="Название должно содержать от 5 до 15 символов")
    private  String name;
    @NotEmpty(message="Вид рода не должен быть пустым")
    @Size(min=5,max=15,message="Вид рода должен содержать не менее 5 символов")
    @Pattern(regexp = "[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9_]*",message = "Вид рода должно начиать с буквой")
    private  String genusType;
    @NotEmpty(message="Семейство не должно быть пустым")
    @Size(min=7,max=15,message="Семейство должно содержать от 7 до 35 символов")
    @Pattern(regexp = "[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9_]*",message = "Семейство должно начиать с буквой")
    private  String family;
    @NotEmpty(message="Распронение не должно быть пустым")
    @Size(min=5,max=15,message="Распронение должно содержать не менее 5 символов")
    @Pattern(regexp = "[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9_]*",message = "Распронение должно начиать с буквой")
    private  String distribution;
}
