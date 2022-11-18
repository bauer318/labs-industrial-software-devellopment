package ru.rsreu.kibamba.lw1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ru.rsreu.kibamba.lw1.MongoDbSequence;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class MongoDbSequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName){
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seqNo",1);
        MongoDbSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),MongoDbSequence.class);
        return !Objects.isNull(counter)?counter.getSeqNo():1;
    }
}
