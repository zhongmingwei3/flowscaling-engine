package com.allqj.workflow.engine.agenda;

/**
 * 流程运转队列
 *
 * @author Zhong
 * @since 1.0
 */
public interface IWorkFlowAgenda {
    IWorkFlowAgenda add(Runnable runnable);

    boolean isNotEmpty();

    Runnable poll();
}
