package ru.rsreu.kibamba.lw1.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.kibamba.lw1.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
