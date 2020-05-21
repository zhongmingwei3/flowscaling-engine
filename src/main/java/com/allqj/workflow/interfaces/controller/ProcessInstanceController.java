package com.allqj.workflow.interfaces.controller;

import com.allqj.workflow.application.service.ProcessInstanceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/process_instance")
public class ProcessInstanceController {

    private final ProcessInstanceService processInstanceService;

    public ProcessInstanceController(ProcessInstanceService processInstanceService) {
        this.processInstanceService = processInstanceService;
    }

    @PostMapping("/process_instance/{process_id}")
    public String createProcessInstace(@PathVariable("process_id") String processId) {
        return processInstanceService.createProcessInstance(processId).getId();
    }

}
