package com.allqj.workflow.engine.operation.impl;

import com.allqj.workflow.engine.element.IElement;
import com.allqj.workflow.engine.element.IStartNode;
import com.allqj.workflow.engine.element.ITransition;
import com.allqj.workflow.engine.exception.WorkflowException;
import com.allqj.workflow.engine.operation.ExecutionEntity;
import com.allqj.workflow.engine.operation.IStartOperation;
import com.allqj.workflow.engine.operation.ITransitionOperation;

/**
 * todo 开始节点的执行逻辑
 *
 * @author Zhong
 * @since 1.0
 */
public class StartOperation implements IStartOperation {

    private final ITransitionOperation transitionOperation;

    public StartOperation(ITransitionOperation transitionOperation) {
        this.transitionOperation = transitionOperation;
    }

    @Override
    public void execute(ExecutionEntity executionEntity) {
        IElement currentElement = executionEntity.getCurrentElement();
        if (currentElement instanceof IStartNode) {
            IStartNode startNode = (IStartNode) currentElement;
            //启动事件

            //下一连线
            ITransition transition = executionEntity.getProcessDefinition().getTransitionById(startNode.getNext());
            executionEntity.setCurrentElement(transition);
            //放入执行队列
        } else {
            throw new WorkflowException("元素不是一个开始节点");
        }
    }
}
