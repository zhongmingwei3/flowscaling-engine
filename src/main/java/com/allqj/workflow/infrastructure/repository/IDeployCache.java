package com.allqj.workflow.infrastructure.repository;

import com.allqj.workflow.engine.definition.IProcessDefinition;

public interface IDeployCache {
    void add(String key, IProcessDefinition IProcessDefinition);

    IProcessDefinition get(String key);

    boolean isDeployed(String key);
}
