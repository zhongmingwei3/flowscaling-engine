package com.allqj.workflow.engine.operation;

import com.allqj.workflow.engine.definition.IProcessDefinition;
import com.allqj.workflow.engine.element.IElement;

/**
 * 执行操作费是的上下文
 *
 * @author Zhong
 * @since 1.0
 */
public class ExecutionEntity {
    /**
     * 将要执行的元素
     */
    private IElement element;
    /**
     * 已经部署的流程定义
     */
    private IProcessDefinition processDefinition;

    public void setCurrentElement(IElement element) {
        this.element = element;
    }

    public IElement getElement() {
        return element;
    }

    public void setProcessDefinition(IProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }

    public IProcessDefinition getProcessDefinition() {
        return processDefinition;
    }
}
