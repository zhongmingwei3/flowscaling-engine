package com.allqj.workflow.infrastructure.repository;

import com.allqj.workflow.engine.element.IUserTaskNode;

public interface IUserTaskRepository {
    IUserTaskNode save(IUserTaskNode userTaskNode);
}
