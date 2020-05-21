package com.allqj.workflow.infrastructure.repository.dataobj;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("biz_process")
public class ProcessDefinitionDO extends BaseDO {
    protected String name;
    protected String description;
    protected String elementJson;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getElementJson() {
        return elementJson;
    }

    public void setElementJson(String elementJson) {
        this.elementJson = elementJson;
    }
}
