package com.allqj.workflow.application.service;

import com.allqj.workflow.engine.cmd.ICommand;
import com.allqj.workflow.engine.deployment.IProcessDeployment;
import com.allqj.workflow.engine.definition.IProcessDefinition;
import com.allqj.workflow.engine.deployment.ProcessDeployment;
import com.allqj.workflow.infrastructure.repository.DeploymentRepository;
import com.allqj.workflow.infrastructure.repository.IDeployCache;
import com.allqj.workflow.infrastructure.repository.ProcessRepository;
import org.springframework.stereotype.Component;


/**
 * 部署相关
 *
 * @author Zhong
 * @since 1.0
 */
@Component
public class DeploymentService {
    private final ICommand<IProcessDeployment, String> deployCmd;
    private final ProcessRepository processRepository;
    private final DeploymentRepository deploymentRepository;
    private final IDeployCache deployCache;

    public DeploymentService(ICommand<IProcessDeployment, String> deployCmd,
                             ProcessRepository processRepository,
                             DeploymentRepository deploymentRepository,
                             IDeployCache deployCache) {
        this.deployCmd = deployCmd;
        this.processRepository = processRepository;
        this.deploymentRepository = deploymentRepository;
        this.deployCache = deployCache;
    }

    /**
     * 根据流程id部署
     *
     * @param processId 流程id
     * @return 部署id
     */
    public String deploy(String processId) {
        //查询流程model
        IProcessDefinition processDefinition = processRepository.findByIdAndIsDeleteFalse(processId);
        //解析元素json
        processDefinition.parsedElements();

        //保存部署数据
        IProcessDeployment deployment = new ProcessDeployment();
        deployment.setId(processDefinition.getId());
        deployment.setName(processDefinition.getName());
        deployment = deploymentRepository.save(deployment);

        //添加到缓存，放到最后避免发生异常无法回滚缓存
        deployCache.add(processDefinition.getId(), processDefinition);
        return deployment.getId();
    }
}
