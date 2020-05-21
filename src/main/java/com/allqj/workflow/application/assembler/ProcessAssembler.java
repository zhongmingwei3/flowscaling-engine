package com.allqj.workflow.application.assembler;

import com.allqj.workflow.engine.definition.IProcessDefinition;
import com.allqj.workflow.engine.definition.ProcessDefinition;
import com.allqj.workflow.interfaces.dto.ProcessDTO;
import org.springframework.stereotype.Component;

@Component
public class ProcessAssembler {
    public IProcessDefinition toEntity(ProcessDTO processDTO) {
        IProcessDefinition processDefinition = new ProcessDefinition();
        processDefinition.setId(processDTO.getId());
        processDefinition.setName(processDTO.getName());
        processDefinition.setDescription(processDTO.getDescription());
        processDefinition.setElementJson(processDTO.getElementJson());
        return processDefinition;
    }
}
