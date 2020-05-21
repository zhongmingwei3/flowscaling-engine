package com.allqj.workflow.engine.element;

public class Transition extends IElement {
    protected String next;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
