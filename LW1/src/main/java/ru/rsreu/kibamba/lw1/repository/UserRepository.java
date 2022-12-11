package ru.rsreu.kibamba.lw1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.rsreu.kibamba.lw1.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
