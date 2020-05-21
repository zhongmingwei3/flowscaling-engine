package com.allqj.workflow.engine.definition;

import com.allqj.workflow.engine.element.INode;
import com.allqj.workflow.engine.element.impl.StartNodeImpl;
import com.allqj.workflow.engine.element.Transition;
import com.allqj.workflow.infrastructure.repository.dataobj.ProcessDefinitionDO;

public class ProcessDefinition extends ProcessDefinitionDO implements IProcessDefinition {
    @Override
    public void parsedElements() {

    }

    @Override
    public StartNodeImpl getStartNode() {
        return null;
    }

    @Override
    public Transition getNextTransitionByNodeId(String nodeId) {
        return null;
    }

    @Override
    public INode getNodeById(String nodeId) {
        return null;
    }

    @Override
    public ProcessDefinitionDO toDataObj() {
        return null;
    }
}
