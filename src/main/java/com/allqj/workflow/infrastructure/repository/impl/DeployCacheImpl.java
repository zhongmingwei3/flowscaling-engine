package com.allqj.workflow.infrastructure.repository.impl;

import com.allqj.workflow.engine.definition.IProcessDefinition;
import com.allqj.workflow.infrastructure.repository.IDeployCache;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DeployCacheImpl implements IDeployCache {

    private final Map<String, IProcessDefinition> processDepfinitions = new HashMap<>(200);

    @Override
    public void add(String key, IProcessDefinition IProcessDefinition) {
        processDepfinitions.put(key, IProcessDefinition);
    }

    @Override
    public IProcessDefinition get(String key) {
        return processDepfinitions.get(key);
    }

    @Override
    public boolean isDeployed(String key) {
        return processDepfinitions.containsKey(key);
    }
}
