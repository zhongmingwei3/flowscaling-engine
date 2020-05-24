package com.allqj.workflow.engine.element;

/**
 * 所有的流程元素都要继承该接口
 */
public interface IElement {
    void setId(String id);

    String getId();
}
