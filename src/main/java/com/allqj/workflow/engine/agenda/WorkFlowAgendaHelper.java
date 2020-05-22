package com.allqj.workflow.engine.agenda;

/**
 * 命令执行过程中的上下文信息
 *
 * @author Zhong
 * @sine 1.0
 */
public class WorkFlowAgendaHelper {

    private static final ThreadLocal<IWorkFlowAgenda> workFlowAgendaThreadLocal = new ThreadLocal<IWorkFlowAgenda>();

    /**
     * 获取当前线程的队列
     */
    public static IWorkFlowAgenda getAgenda() {
        IWorkFlowAgenda workFlowAgenda = workFlowAgendaThreadLocal.get();
        if (workFlowAgenda == null) {
            // TODO: 2020/5/22 创建agenda
        }
        return workFlowAgenda;
    }
}
