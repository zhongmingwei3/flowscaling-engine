package com.allqj.workflow.infrastructure.repository;

import com.allqj.workflow.engine.deployment.IProcessDeployment;

public interface DeploymentRepository {
    IProcessDeployment save(IProcessDeployment deployment);
}
