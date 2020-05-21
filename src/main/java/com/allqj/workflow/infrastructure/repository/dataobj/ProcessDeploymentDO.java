package com.allqj.workflow.infrastructure.repository.dataobj;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("biz_deployment")
public class ProcessDeploymentDO extends BaseDO {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
