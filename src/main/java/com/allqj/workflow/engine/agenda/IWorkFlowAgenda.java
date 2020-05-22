package com.allqj.workflow.engine.agenda;

/**
 * 流程运转队列
 *
 * @author Zhong
 * @since 1.0
 */
public interface IWorkFlowAgenda {
    /**
     * 添加一个运行到队列
     */
    IWorkFlowAgenda add(Runnable runnable);

    /**
     * 判断队列是否为空
     *
     * @return 不为空返回 true
     */
    boolean isNotEmpty();

    /**
     * 再队列读取一个
     *
     * @return
     */
    Runnable poll();

    /**
     * 执行队列
     */
    void execute();
}
