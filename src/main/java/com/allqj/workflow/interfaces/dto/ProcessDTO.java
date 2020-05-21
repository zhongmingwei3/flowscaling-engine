package com.allqj.workflow.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 流程定义
 *
 * @author Zhong
 * @since 1.0
 */
@Getter
@Setter
public class ProcessDTO {
    protected String id;
    protected String name;
    protected String description;
    protected String elementJson;
}
