package com.allqj.workflow.infrastructure.repository.impl;

import com.allqj.workflow.engine.definition.IProcessDefinition;
import com.allqj.workflow.engine.definition.ProcessDefinition;
import com.allqj.workflow.infrastructure.repository.ProcessRepository;
import com.allqj.workflow.infrastructure.repository.dataobj.ProcessDefinitionDO;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class ProcessRepositoryImpl implements ProcessRepository {

    private final MongoTemplate mongoTemplate;

    public ProcessRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public IProcessDefinition save(IProcessDefinition processDefinition) {
        return (ProcessDefinition) mongoTemplate.save(processDefinition.toDataObj());
    }

    @Override
    public IProcessDefinition findByIdAndIsDeleteFalse(String id) {
        Criteria criteria = Criteria.where("_id").is(id).and("isdelete").is(false);
        Query query = new Query(criteria);
        ProcessDefinitionDO processDefinitionDo = mongoTemplate.findOne(query, ProcessDefinitionDO.class);
        return (ProcessDefinition) processDefinitionDo;
    }

}
