package com.allqj.workflow.configure;

import com.allqj.workflow.engine.cmd.impl.StartProcessInstanceCmd;
import com.allqj.workflow.infrastructure.repository.IDeployCache;
import com.allqj.workflow.infrastructure.repository.IUserTaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean管理
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public IUserTaskRepository userTaskRepository() {
        // TODO: 2020/5/18 用户任务仓储bean
        return null;
    }

    @Bean
    public IDeployCache deployCache() {
        // TODO: 2020/5/18 部署缓存 bean
        return null;
    }

    @Bean
    public StartProcessInstanceCmd startProcessInstanceCmd(IUserTaskRepository userTaskRepository,
                                                           IDeployCache deployCache) {
        // TODO: 2020/5/18 启动流程实例bean
        return null;
    }
}
