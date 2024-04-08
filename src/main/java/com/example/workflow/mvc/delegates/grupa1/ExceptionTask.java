package com.example.workflow.mvc.delegates.grupa1;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ExceptionTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        throw new RuntimeException("pppp");
    }
}
