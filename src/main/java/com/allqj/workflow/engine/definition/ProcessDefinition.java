package com.allqj.workflow.engine.definition;

import com.allqj.workflow.engine.element.INode;
import com.allqj.workflow.engine.element.IStartNode;
import com.allqj.workflow.engine.element.ITransition;
import com.allqj.workflow.infrastructure.repository.dataobj.ProcessDefinitionDO;

public class ProcessDefinition extends ProcessDefinitionDO implements IProcessDefinition {
    @Override
    public void parsedElements() {

    }

    @Override
    public IStartNode getStartNode() {
        return null;
    }

    @Override
    public ITransition getTransitionById(String nodeId) {
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
