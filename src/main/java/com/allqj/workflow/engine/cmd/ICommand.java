package com.allqj.workflow.engine.cmd;

public interface ICommand<T, E> {
    T execute(E e);
}
