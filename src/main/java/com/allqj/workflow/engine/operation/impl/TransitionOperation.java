package com.allqj.workflow.engine.operation.impl;

import com.allqj.workflow.engine.operation.AbstractOperation;
import com.allqj.workflow.engine.operation.ExecutionEntity;

/**
 * todo 开始节点操作实现
 *
 * @author Zhong
 * @since 1.0
 */
public class TransitionOperation extends AbstractOperation {

    public TransitionOperation(ExecutionEntity executionEntity) {
        super(executionEntity);
    }

    @Override
    public void run() {
        //表达式条件判断

        //查询下一节点

        //如果是用户任务，则更新流程实例的执行节点，并保存任务


    }
}
