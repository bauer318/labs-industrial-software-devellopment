package ru.rsreu.kibamba.lw1.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table(name = "medicinal_herb")
public class MedicinalHerb {
    @Id
    @Column(name = "herb_id")
    private  int id;

    @NotEmpty(message="Название травы не должно быть пустым")
    @Pattern(regexp = "[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9_]*",message = "Название должно начиать с буквой")
    @Size(min=5,max=15,message="Название должно содержать от 5 до 15 символов")
    @Column(name = "herb_name")
    private  String name;

    @NotEmpty(message="Вид рода не должен быть пустым")
    @Size(min=5,max=15,message="Вид рода должен содержать не менее 5 символов")
    @Pattern(regexp = "[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9_]*",message = "Вид рода должно начиать с буквой")
    @Column(name="genus_type")
    private  String genusType;

    @NotEmpty(message="Семейство не должно быть пустым")
    @Size(min=7,max=15,message="Семейство должно содержать от 7 до 35 символов")
    @Pattern(regexp = "[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9_]*",message = "Семейство должно начиать с буквой")
    @Column(name = "herb_family")
    private  String family;

    @NotEmpty(message="Распронение не должно быть пустым")
    @Size(min=5,max=15,message="Распронение должно содержать не менее 5 символов")
    @Pattern(regexp = "[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9_]*",message = "Распронение должно начиать с буквой")
    private  String distribution;
    @Min(value = 1,message="минимальное количество штук - одно")
    @Max(value = 100, message="максимальное количество штук - сто")
    private int piece;
    @Min(value = 1, message = "минамальная цена травы - 1")
    private double price;
    @Column(name = "picture_link")
    private String pictureLink;
}
