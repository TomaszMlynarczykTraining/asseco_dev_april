package com.example.workflow.mvc.delegates.grupa3;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;


@Component
public class UserTaskListenerGrupa3 implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setDueDate(LocalDateTime.now().toDate());
    }
}
