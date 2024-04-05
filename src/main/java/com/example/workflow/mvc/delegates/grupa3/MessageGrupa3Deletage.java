package com.example.workflow.mvc.delegates.grupa3;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageGrupa3Deletage implements JavaDelegate {
    @Autowired
    RuntimeService runtimeService;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        runtimeService.correlateMessage("Message_from_Group_3");
    }
}
