package ru.rsreu.kibamba.lw1.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.kibamba.lw1.models.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String> {
}
