package com.Sampleassessment.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class SequenceGenerate {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public int categorySeqId(String categoryid) {
		categorySequenceGeneration seq = null;
		try {
			categorySequenceId();
			Query query = new Query(Criteria.where("categoryid").is(categoryid));

			Update update = new Update();
			update.inc("sequenceNum", 1);

			FindAndModifyOptions options = new FindAndModifyOptions();
			options.returnNew(true);

			seq = mongoTemplate.findAndModify(query, update, options, categorySequenceGeneration.class);

			if (seq == null) {
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return seq.getSequenceNum();
	}

	private void categorySequenceId() {
		// TODO Auto-generated method stub
		if (!mongoTemplate.collectionExists("categoryIdSequence")) {
			categorySequenceGeneration Sequence = new categorySequenceGeneration();
			Sequence.setCategoryid("categoryid");
			Sequence.setSequenceNum(0);
			mongoTemplate.save(Sequence);
		}
	}

	public int subcategorySeqId(String subid) {
		// TODO Auto-generated method stub
		subcategorySequenceGeneration seq = null;
		try {
			TestcategorySequenceGeneration();
			Query query = new Query(Criteria.where("subid").is(subid));

			Update update = new Update();
			update.inc("sequenceNum", 1);

			FindAndModifyOptions options = new FindAndModifyOptions();
			options.returnNew(true);

			seq = mongoTemplate.findAndModify(query, update, options, subcategorySequenceGeneration.class);

			if (seq == null) {
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return seq.getSequenceNum();
	}

	private void TestcategorySequenceGeneration() {
		// TODO Auto-generated method stub
		if (!mongoTemplate.collectionExists("subcategoryIdSequence")) {
			subcategorySequenceGeneration Sequence = new subcategorySequenceGeneration();
			Sequence.setSubid("subid");
			Sequence.setSequenceNum(0);
			mongoTemplate.save(Sequence);
		}
	}

	
}
