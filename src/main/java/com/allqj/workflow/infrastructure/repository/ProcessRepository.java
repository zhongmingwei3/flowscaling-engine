package com.allqj.workflow.infrastructure.repository;

import com.allqj.workflow.engine.definition.IProcessDefinition;

/**
 * 流程定义仓储
 *
 * @author Zhong
 * @since 1.0
 */
public interface ProcessRepository {
    /**
     * 根据主键获取定义流程
     *
     * @param id id
     * @return
     */
    IProcessDefinition findByIdAndIsDeleteFalse(String id);

    /**
     * 新增或修改一个流程定义
     * @param IProcessDefinition
     * @return
     */
    IProcessDefinition save(IProcessDefinition IProcessDefinition);
}
