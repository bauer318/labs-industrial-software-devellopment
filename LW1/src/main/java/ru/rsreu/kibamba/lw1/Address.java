package ru.rsreu.kibamba.lw1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class Address {
    @NotBlank(message = "название населеного пункта не должно быть пустым")
    private String state;
    @NotBlank(message = "название города не должно быть пустым")
    private String town;
}
