package com.allqj.workflow.interfaces.controller;

import com.allqj.workflow.application.service.DeploymentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/deployment")
public class DeploymentController {

    private final DeploymentService deploymentService;

    public DeploymentController(DeploymentService deploymentService) {
        this.deploymentService = deploymentService;
    }

    @PostMapping("/deployment/{process_id}")
    public String createDeployment(@PathVariable("process_id") String processId) {
        return deploymentService.deploy(processId);
    }

}
