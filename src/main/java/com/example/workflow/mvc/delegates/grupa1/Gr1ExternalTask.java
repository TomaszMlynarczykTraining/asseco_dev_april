package com.example.workflow.mvc.delegates.grupa1;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("gr1External")
public class Gr1ExternalTask implements ExternalTaskHandler {
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        VariableMap variables = Variables.createVariables();
        variables.put("extVar", "var from external ");
        //externalTaskService.complete(externalTask, variables);

        //externalTaskService.handleBpmnError(externalTask, "aaa");

        Integer i = externalTask.getRetries();
        if (i == null) i = 3;
        if (i > 0) {
            externalTaskService.handleFailure(externalTask, "failure msg", null, --i, 1000);
        } else {
            externalTaskService.complete(externalTask, variables);
        }

        //throw new BpmnError("err from ext");
    }
}
