package com.example.workflow.mvc.delegates.grupa1;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component
public class PolaczDostawyDelegate implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {

        String listaDostaw = (String) delegateTask.getVariable("listaDostaw");
        String dostawa = (String) delegateTask.getVariable("dostawa");

        listaDostaw = listaDostaw + dostawa;
        delegateTask.setVariable("listadostaw", listaDostaw);
    }
}
