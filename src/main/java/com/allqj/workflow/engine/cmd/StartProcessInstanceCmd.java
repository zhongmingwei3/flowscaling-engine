package com.allqj.workflow.engine.cmd;

import com.allqj.workflow.engine.agenda.IWorkFlowAgenda;
import com.allqj.workflow.engine.agenda.WorkFlowAgendaUtil;
import com.allqj.workflow.engine.definition.IProcessDefinition;
import com.allqj.workflow.engine.element.IStartNode;
import com.allqj.workflow.engine.operation.IStartOperation;
import com.allqj.workflow.engine.runtime.IProcessInstance;
import com.allqj.workflow.infrastructure.repository.IDeployCache;
import com.allqj.workflow.infrastructure.repository.IUserTaskRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 启动流程实例实现
 *
 * @author Zhong
 * @since 1.0
 */
public class StartProcessInstanceCmd implements Command<IProcessInstance, String> {

    private final IUserTaskRepository userTaskRepository;
    private final IDeployCache deployCache;
    private final IStartOperation startOperation;

    public StartProcessInstanceCmd(IUserTaskRepository userTaskRepository,
                                   IDeployCache deployCache,
                                   IStartOperation startOperation) {
        this.userTaskRepository = userTaskRepository;
        this.deployCache = deployCache;
        this.startOperation = startOperation;
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
        //放入队列等待执行
        IWorkFlowAgenda agenda = WorkFlowAgendaUtil.getAgenda();
        agenda.add(() -> startOperation.execute(startNode));
        //开始执行
        this.startProcess(agenda);
        return processInstance;
    }

    /**
     * 开始流程运转
     *
     * @param agenda 等待执行的流程元素队列
     */
    private void startProcess(IWorkFlowAgenda agenda) {
        //循环执行元素
        while (agenda.isNotEmpty()) {
            agenda.poll().run();
        }
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
