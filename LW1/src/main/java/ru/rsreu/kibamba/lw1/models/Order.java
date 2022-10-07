package ru.rsreu.kibamba.lw1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Order {
    private int ID;
    @Pattern(regexp = "(\\+7)[0-9]{10}",message = "формат телефона +7XXXXXXXXXX")
    private String buyerTelephone;

    @NotBlank(message="Название травы не должно быть пустым")
    private String medicinalHerbName;

    @Min(value = 1,message="минимальное количество штук - одно")
    private int totalPiece;
    private double totalPrice;
    private OrderStatus status;
}
