package ru.rsreu.kibamba.lw1.form;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.kibamba.lw1.models.User;


import javax.validation.constraints.NotBlank;

@Data
public class RegistrationForm {

    @NotBlank(message = "Username should not be blank")
    private String username;

    @NotBlank(message = "Password should not be blank")
    private String password;

    public User toUser(PasswordEncoder encoder) {
        return new User(username, encoder.encode(password));
    }

}
