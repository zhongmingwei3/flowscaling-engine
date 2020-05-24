package com.allqj.workflow.engine.operation.impl;

import com.allqj.workflow.engine.element.IElement;
import com.allqj.workflow.engine.element.ITransition;
import com.allqj.workflow.engine.element.IUserTaskNode;
import com.allqj.workflow.engine.exception.WorkflowException;
import com.allqj.workflow.engine.operation.ExecutionEntity;
import com.allqj.workflow.engine.operation.ITransitionOperation;
import com.allqj.workflow.infrastructure.repository.IUserTaskRepository;

/**
 * todo 连接线操作实现
 *
 * @author Zhong
 * @since 1.0
 */
public class TransitionOperation implements ITransitionOperation {

    private final IUserTaskRepository userTaskRepository;

    public TransitionOperation(IUserTaskRepository userTaskRepository) {
        this.userTaskRepository = userTaskRepository;
    }

    @Override
    public void execute(ExecutionEntity executionEntity) {
        IElement currentElement = executionEntity.getCurrentElement();
        if (currentElement instanceof ITransition) {
            ITransition transition = (ITransition) currentElement;
            //表达式条件判断
            String condition = transition.getCodition();

            //查询下一节点
            IElement element = executionEntity.getProcessDefinition().getNodeById(transition.getNext());
            if (element instanceof IUserTaskNode) {
                IUserTaskNode userTaskNode = (IUserTaskNode) element;
                //保存用户任务
                userTaskRepository.save(userTaskNode);
            }

            //其他任务，网关

        } else {
            throw new WorkflowException("元素类型错误：不是连线");
        }
    }

}
