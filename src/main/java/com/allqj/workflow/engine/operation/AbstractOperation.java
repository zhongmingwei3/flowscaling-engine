package com.allqj.workflow.engine.operation;

public abstract class AbstractOperation implements IOperation {
    protected final ExecutionEntity executionEntity;

    public AbstractOperation(ExecutionEntity executionEntity) {
        this.executionEntity = executionEntity;
    }
}
