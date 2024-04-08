package com.example.workflow.mvc.delegates;

import groovyjarjarpicocli.CommandLine;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ErrorDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        throw new RuntimeException();
    }
}
