package com.example.workflow.mvc.delegates.grupa4;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class Grupa4TaskListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setDueDate(new Date());
        log.info("Zmieniono due data taska " + delegateTask.getName() + " na " + delegateTask.getDueDate());
    }
}
