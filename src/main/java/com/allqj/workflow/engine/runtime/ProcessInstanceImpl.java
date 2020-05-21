package com.allqj.workflow.engine.runtime;

/**
 * 流程运行实例
 *
 * @author Zhong
 * @since 1.0
 */
public class ProcessInstanceImpl implements IProcessInstance {

    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
