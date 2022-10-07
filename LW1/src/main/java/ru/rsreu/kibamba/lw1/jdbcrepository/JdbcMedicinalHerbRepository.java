package ru.rsreu.kibamba.lw1.jdbcrepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.rsreu.kibamba.lw1.models.MedicinalHerb;
import ru.rsreu.kibamba.lw1.repositorys.MedicinalHerbRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcMedicinalHerbRepository implements MedicinalHerbRepository {


    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;
    public JdbcMedicinalHerbRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName("medicinal_herb").usingGeneratedKeyColumns("herb_id");
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
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("herb_name",medicinalHerb.getName());
        parameters.put("genus_type",medicinalHerb.getGenusType());
        parameters.put("family",medicinalHerb.getFamily());
        parameters.put("distribution",medicinalHerb.getDistribution());
        parameters.put("piece",medicinalHerb.getPiece());
        parameters.put("price",medicinalHerb.getPrice());
        parameters.put("picture_link","");
        simpleJdbcInsert.execute(parameters);
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
