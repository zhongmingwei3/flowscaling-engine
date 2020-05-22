package com.allqj.workflow.engine.cmd;

import com.allqj.workflow.infrastructure.repository.IUserTaskRepository;

/**
 * 办理用户任务
 *
 * @author ZHong
 * @since 1.0
 */
public class ComplateUserTaskCmd implements ICommand<Void, String> {

    private final IUserTaskRepository userTaskRepository;

    public ComplateUserTaskCmd(IUserTaskRepository userTaskRepository) {
        this.userTaskRepository = userTaskRepository;
    }

    @Override
    public Void execute(String taskId) {
        //查询任务

        //查询流程定义

        //创建执行实体



        return null;
    }
}
