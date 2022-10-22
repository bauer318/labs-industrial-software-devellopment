package ru.rsreu.kibamba.lw1.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Buyer {
    @Id
    @Pattern(regexp = "(\\+7)[0-9]{10}",message = "формат телефона +7XXXXXXXXXX")
    private String telephone;
    @NotBlank(message = "имя покупателя не должно быть пустым")
    private String firstname;
    @NotBlank(message = "название населеного пункта не должно быть пустым")
    private String state;
    @NotBlank(message = "название города не должно быть пустым")
    private String town;
    @NotBlank(message="пароль не должно быть пустым")
    private String password;
    private String role;

}
