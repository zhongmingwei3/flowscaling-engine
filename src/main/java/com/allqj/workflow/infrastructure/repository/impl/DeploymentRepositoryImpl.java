package com.allqj.workflow.infrastructure.repository.impl;

import com.allqj.workflow.engine.deployment.IProcessDeployment;
import com.allqj.workflow.infrastructure.repository.DeploymentRepository;
import com.allqj.workflow.infrastructure.repository.dataobj.ProcessDeploymentDO;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeploymentRepositoryImpl implements DeploymentRepository {

    private final MongoTemplate mongoTemplate;

    public DeploymentRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public IProcessDeployment save(IProcessDeployment deployment) {
        return (IProcessDeployment) mongoTemplate.save((ProcessDeploymentDO) deployment);
    }
}
