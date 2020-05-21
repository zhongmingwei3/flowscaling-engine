package com.allqj.workflow.application.service;

import com.allqj.workflow.application.assembler.ProcessAssembler;
import com.allqj.workflow.infrastructure.repository.ProcessRepository;
import com.allqj.workflow.interfaces.dto.ProcessDTO;
import org.springframework.stereotype.Component;

/**
 * @author Zhong
 * @since 1.0
 */
@Component
public class ProcessDefinitionService {

    private final ProcessRepository processRepository;
    private final ProcessAssembler processAssembler;

    public ProcessDefinitionService(ProcessRepository processRepository, ProcessAssembler processAssembler) {
        this.processRepository = processRepository;
        this.processAssembler = processAssembler;
    }

    /**
     * 创建流程定义
     *
     * @param processDTO 流程定义元素
     * @return 主键
     */
    public String createProcessDefinition(ProcessDTO processDTO) {
        return processRepository.save(processAssembler.toEntity(processDTO)).getId();
    }

    /**
     * 更新流程
     *
     * @param processDTO 流程定义元素
     * @return 主键
     */
    public String updateProcess(ProcessDTO processDTO) {
        return null;
    }

}
