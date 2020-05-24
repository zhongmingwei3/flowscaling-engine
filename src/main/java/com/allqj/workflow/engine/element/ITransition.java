package com.allqj.workflow.engine.element;

public interface ITransition extends IElement {
    String getNext();

    void setNext(String next);

    String getCodition();
}
