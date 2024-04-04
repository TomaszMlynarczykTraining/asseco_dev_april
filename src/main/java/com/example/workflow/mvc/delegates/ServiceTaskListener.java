package com.example.workflow.mvc.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class ServiceTaskListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        execution.setVariable("myVar", "var");
    }
}
