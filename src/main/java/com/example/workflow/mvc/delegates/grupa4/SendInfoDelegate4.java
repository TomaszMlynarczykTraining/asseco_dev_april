package com.example.workflow.mvc.delegates.grupa4;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendInfoDelegate4 implements JavaDelegate {

    @Autowired
    RuntimeService myRuntimeService;

    @Override
    public void execute(DelegateExecution aExec) throws Exception {

        myRuntimeService.correlateMessage("Message_PT1"); // send message

    }
}
