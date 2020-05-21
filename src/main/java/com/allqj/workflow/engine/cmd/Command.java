package com.allqj.workflow.engine.cmd;

public interface Command<T, E> {
    T execute(E e);
}
