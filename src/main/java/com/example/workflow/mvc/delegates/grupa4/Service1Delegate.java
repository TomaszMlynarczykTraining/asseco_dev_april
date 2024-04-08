package com.example.workflow.mvc.delegates.grupa4;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Service1Delegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        throw new RuntimeException("Taki b")
    }
}
