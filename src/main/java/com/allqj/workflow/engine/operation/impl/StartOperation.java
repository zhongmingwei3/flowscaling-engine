package com.allqj.workflow.engine.operation.impl;

import com.allqj.workflow.engine.agenda.WorkFlowAgendaHelper;
import com.allqj.workflow.engine.operation.AbstractOperation;
import com.allqj.workflow.engine.operation.ExecutionEntity;

/**
 * todo 开始节点的执行逻辑
 *
 * @author Zhong
 * @since 1.0
 */
public class StartOperation extends AbstractOperation {

    public StartOperation(ExecutionEntity executionEntity) {
        super(executionEntity);
    }

    @Override
    public void run() {
        //当前节点的逻辑

        //下一连线

        //放入执行队列
        WorkFlowAgendaHelper.getAgenda().add(new TransitionOperation(executionEntity));
    }
}
