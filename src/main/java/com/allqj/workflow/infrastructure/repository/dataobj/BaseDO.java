package com.allqj.workflow.infrastructure.repository.dataobj;

public class BaseDO {
    protected String id;
    protected boolean isdelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }
}
