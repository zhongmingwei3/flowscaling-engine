package com.allqj.workflow.engine.operation;

/**
 * 该接口定义了每个节点要执行的方法，每个节点的操作都要实现该接口
 */
public interface IOperation {
    void execute(ExecutionEntity executionEntity);
}
