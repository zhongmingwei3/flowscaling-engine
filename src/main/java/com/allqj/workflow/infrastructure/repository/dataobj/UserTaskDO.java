package com.allqj.workflow.infrastructure.repository.dataobj;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 用户任务
 *
 * @author Zhong
 * @since 1.0
 */
@Getter
@Setter
@Document("/biz_user_task")
public class UserTaskDO extends BaseDO {

    protected String id;
    protected String processDefinitionId;
    protected String processInstanceId;
    //办理人
    protected String transactor;

}
