package com.example.workflow.mvc.delegates.grupa3;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.vintage.engine.descriptor.RunnerTestDescriptor;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("externalGrupa3")
public class ExternalTaskGrupa3 implements ExternalTaskHandler {


    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Integer retries = externalTask.getRetries();
        if(retries == null){
            retries = 3;
        }
        externalTaskService.handleFailure(externalTask, "Nie dziala", "Szczegoly bledu",--retries,
                1000);
        VariableMap variables = Variables.createVariables();

        Double euro = externalTask.getVariable("euro");
        variables.put("zloty", euro * 4.5);


        externalTaskService.complete(externalTask, variables);
    }
}
