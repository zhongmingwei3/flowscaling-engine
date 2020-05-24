package com.allqj.workflow.infrastructure.repository;

import com.allqj.workflow.engine.deployment.IProcessDeployment;

public interface IDeploymentRepository {
    IProcessDeployment save(IProcessDeployment deployment);
}
