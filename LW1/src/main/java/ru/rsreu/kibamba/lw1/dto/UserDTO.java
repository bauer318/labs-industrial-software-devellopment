package ru.rsreu.kibamba.lw1.dto;

import lombok.Builder;
import lombok.Data;
import ru.rsreu.kibamba.lw1.entity.User;

@Builder
@Data
public class UserDTO {
    private String id;
    private String username;

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}