package com.example.workflow.mvc.delegates.grupa_2;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("gr2_topic1") // create a subscription for this topic name
public class GR2MockExternalTask implements ExternalTaskHandler {


    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {


        System.out.println("jestem w GR2_ET_worker: bizkey=" + externalTask.getBusinessKey());

        VariableMap variables = Variables.createVariables();

        variables.put("customerSurname", "Batman");

        //try {
            throw new RuntimeException("to jest testowy exception");
        /*}
        catch(Exception ex) {
            System.out.println("jestem w GR2_ET_worker catch: retries=" + externalTask.getRetries());
            externalTaskService.handleFailure(externalTask,ex.getMessage(), "detail details",0,0);
        }
*/

        //externalTaskService.complete(externalTask,variables);

    }
}
