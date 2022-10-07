package ru.rsreu.kibamba.lw1;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Buyer {
    @Pattern(regexp = "(\\+7)[0-9]{10}",message = "формат телефона +7XXXXXXXXXX")
    private String telephone;
    @NotBlank(message = "имя покупателя не должно быть пустым")
    private String firstname;
}
