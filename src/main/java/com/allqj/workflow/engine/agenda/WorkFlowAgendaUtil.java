package com.allqj.workflow.engine.agenda;

/**
 * 命令执行过程中的上下文信息
 *
 * @author Zhong
 * @sine 1.0
 */
public class WorkFlowAgendaUtil {

    private static final ThreadLocal<IWorkFlowAgenda> workFlowAgendaThreadLocal = new ThreadLocal<IWorkFlowAgenda>();

    /**
     * 获取当前线程的队列
     */
    public static IWorkFlowAgenda getAgenda() {
        return workFlowAgendaThreadLocal.get();
    }
}
