package ru.rsreu.kibamba.lw1.jdbcrepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.rsreu.kibamba.lw1.models.MedicinalHerb;
import ru.rsreu.kibamba.lw1.repositorys.MedicinalHerbRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMedicinalHerbRepository implements MedicinalHerbRepository {


    private JdbcTemplate jdbcTemplate;
    public JdbcMedicinalHerbRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Iterable<MedicinalHerb> findAll() {
        return jdbcTemplate.query("SELECT * FROM medicinal_herb",this::mapRowToMedicinalHerb);
    }
    @Override
    public Optional<MedicinalHerb> findById(int id) {
        List<MedicinalHerb> results = jdbcTemplate.query("SELECT * FROM medicinal_herb WHERE herb_id =?",this::mapRowToMedicinalHerb,id);
        return results.size()==0?Optional.empty():Optional.of(results.get(0));
    }

    @Override
    public MedicinalHerb save(MedicinalHerb medicinalHerb) {
        jdbcTemplate.update(
                "INSERT INTO MEDICINAL_HERB (herb_name, genus_type, family, distribution, piece, price, picture_link) VALUES" +
                        "(?,?,?,?,?,?,?)",medicinalHerb.getName(),medicinalHerb.getGenusType(),medicinalHerb.getFamily(),
                medicinalHerb.getDistribution(),medicinalHerb.getPiece(),medicinalHerb.getPrice(),""
        );
        return medicinalHerb;
    }
    private MedicinalHerb  mapRowToMedicinalHerb(ResultSet row, int rowNum) throws SQLException {
        return new MedicinalHerb(
                row.getInt("herb_id"),
                row.getString("herb_name"),
                row.getString("genus_type"),
                row.getString("family"),
                row.getString("distribution"),
                row.getInt("piece"),
                row.getDouble("price")
        );
    }

}
