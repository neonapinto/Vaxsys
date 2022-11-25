package com.vaxsys.repository;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.vaxsys.model.CustomSequences;

@Service
public class SequenceGeneratorService {

	@Autowired
    private MongoOperations operations;
 
    public long getNextSequence(final String sequenceName) {

		  CustomSequences counter =
		  operations.findAndModify(query(where("_id").is(sequenceName)), new
		  Update().inc("seq",1), options().returnNew(true).upsert(true),
		  CustomSequences.class); return !Objects.isNull(counter) ? counter.getSeq() :
		  1;
		 
        
    }

}
