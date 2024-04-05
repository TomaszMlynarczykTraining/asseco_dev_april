package com.example.workflow.mvc.delegates;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendInfoDelegate implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        runtimeService.correlateMessage("MSG_SEND_INFO");

    }
}
