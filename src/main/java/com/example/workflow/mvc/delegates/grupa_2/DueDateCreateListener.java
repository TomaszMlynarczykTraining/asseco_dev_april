package com.example.workflow.mvc.delegates.grupa_2;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DueDateCreateListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setDueDate(new Date());
    }
}
