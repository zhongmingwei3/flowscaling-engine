package com.allqj.workflow.engine.cmd;

import com.allqj.workflow.engine.deployment.IProcessDeployment;
import com.allqj.workflow.engine.definition.IProcessDefinition;
import com.allqj.workflow.engine.deployment.ProcessDeployment;
import com.allqj.workflow.infrastructure.repository.IDeployCache;
import com.allqj.workflow.infrastructure.repository.IDeploymentRepository;
import com.allqj.workflow.infrastructure.repository.ProcessRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部署流程
 *
 * @author Zhong
 * @since 1.0
 */
// TODO: 2020/5/18 改造：bean创建统一到配置
@Component
public class DeployCmd implements ICommand<IProcessDeployment, String> {

    private final ProcessRepository processRepository;
    private final IDeploymentRepository deploymentRepository;
    private final IDeployCache deployCache;

    public DeployCmd(ProcessRepository processRepository, IDeploymentRepository deploymentRepository, IDeployCache deployCache) {
        this.processRepository = processRepository;
        this.deploymentRepository = deploymentRepository;
        this.deployCache = deployCache;
    }

    @Transactional
    @Override
    public IProcessDeployment execute(String processId) {
        if (deployCache.isDeployed(processId)) {
//            throw new WorkflowException("流程已经部署");
        }
        //查询流程
        IProcessDefinition processDefinition = processRepository.findByIdAndIsDeleteFalse(processId);
        //解析元素json
        processDefinition.parsedElements();
        //部署
        IProcessDeployment deployment = new ProcessDeployment();
        deployment.setId(processDefinition.getId());
        deployment.setName(processDefinition.getName());
        //保存数据库
        deployment = deploymentRepository.save(deployment);

        //保存到缓存,放到最后避免发生异常无法回滚缓存
        deployCache.add(processDefinition.getId(), processDefinition);
        return deployment;
    }

}
