package com.example.workflow.mvc.delegates;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("externalDelegate") // create a subscription for this topic name
public class MockExternalTask implements ExternalTaskHandler {


    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        System.out.println(externalTask.getBusinessKey());

        VariableMap variables = Variables.createVariables();

        variables.put("customerSurname", "Batman");
        throw new RuntimeException();

       // externalTaskService.handleFailure(externalTask, "a","b",0,2);

        //externalTaskService.handleFailure();
        //externalTaskService.complete(externalTask, variables);

    }
}
