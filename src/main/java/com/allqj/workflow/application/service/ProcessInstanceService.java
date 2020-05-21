package com.allqj.workflow.application.service;

import com.allqj.workflow.engine.runtime.IProcessInstance;
import com.allqj.workflow.infrastructure.repository.IDeployCache;
import com.allqj.workflow.engine.cmd.StartProcessInstanceCmd;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 流程实例服务
 *
 * @author Zhong
 * @since 1.0
 */
@Component
public class ProcessInstanceService {

    private final IDeployCache deployCache;
    private final StartProcessInstanceCmd startProcessInstanceCmd;

    public ProcessInstanceService(IDeployCache deployCache,
                                  StartProcessInstanceCmd startProcessInstanceCmd) {
        this.deployCache = deployCache;
        this.startProcessInstanceCmd = startProcessInstanceCmd;
    }

    @Transactional
    public IProcessInstance createProcessInstance(String processId) {
        //启动流程实例
        return startProcessInstanceCmd.execute(processId);
    }
}
