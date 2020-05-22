package com.allqj.workflow.engine.cmd;

import com.allqj.workflow.engine.agenda.WorkFlowAgendaHelper;
import com.allqj.workflow.engine.definition.IProcessDefinition;
import com.allqj.workflow.engine.element.IStartNode;
import com.allqj.workflow.engine.operation.IContinueOperation;
import com.allqj.workflow.engine.operation.ExecutionEntity;
import com.allqj.workflow.engine.operation.impl.StartOperation;
import com.allqj.workflow.engine.runtime.IProcessInstance;
import com.allqj.workflow.infrastructure.repository.IDeployCache;
import org.springframework.transaction.annotation.Transactional;

/**
 * 启动流程实例实现
 *
 * @author Zhong
 * @since 1.0
 */
public class StartProcessInstanceCmd implements ICommand<IProcessInstance, String> {

    private final IDeployCache deployCache;
    private final IContinueOperation continueOperation;

    public StartProcessInstanceCmd(IDeployCache deployCache,
                                   IContinueOperation continueOperation) {
        this.deployCache = deployCache;
        this.continueOperation = continueOperation;
    }

    @Transactional
    @Override
    public IProcessInstance execute(String processId) {
        //查询流程定义
        IProcessDefinition processDefinition = deployCache.get(processId);

        //创建流程实例,并保存
        IProcessInstance processInstance = this.createProcessInstance(processDefinition);

        //拿出开始节点
        IStartNode startNode = processDefinition.getStartNode();

        //创建执行实体
        ExecutionEntity executionEntity = new ExecutionEntity();
        executionEntity.setCurrentElement(startNode);
        executionEntity.setProcessDefinition(processDefinition);

        //执行
        WorkFlowAgendaHelper.getAgenda().add(new StartOperation(executionEntity)).execute();
        return processInstance;
    }

    /**
     * 创建流程实例
     *
     * @param processDefinition 流程定义
     * @return 流程实例
     */
    private IProcessInstance createProcessInstance(IProcessDefinition processDefinition) {
        // TODO: 2020/5/18  创建流程实例
        return null;
    }
}
