package com.allqj.workflow.interfaces.controller;

import com.allqj.workflow.application.service.ProcessDefinitionService;
import com.allqj.workflow.interfaces.dto.ProcessDTO;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/process_definition")
public class ProcessDefinitionController {

    private final ProcessDefinitionService processDefinitionService;

    public ProcessDefinitionController(ProcessDefinitionService processDefinitionService) {
        this.processDefinitionService = processDefinitionService;
    }

    @PostMapping("/process_model")
    public String createProcess(@RequestBody ProcessDTO processDTO) {
        return processDefinitionService.createProcessDefinition(processDTO);
    }

    @PutMapping("/process_model")
    public String updateProcess(@RequestBody ProcessDTO processDTO) {
        return processDefinitionService.updateProcess(processDTO);
    }

}
