package com.example.workflow.mvc.delegates.grupa_2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class Wait5MinutesDelegates implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Thread.sleep(360000);
        System.out.println("run");
    }

}
