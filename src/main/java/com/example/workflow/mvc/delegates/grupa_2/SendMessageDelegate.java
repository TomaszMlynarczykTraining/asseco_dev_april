package com.example.workflow.mvc.delegates.grupa_2;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.stereotype.Component;

@Component
public class SendMessageDelegate implements JavaDelegate {

    public final RuntimeService runtimeService;


    public SendMessageDelegate(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
//        runtimeService.correlateMessage("TERMINATE_USER_TASK");
        MessageCorrelationResult result = runtimeService.createMessageCorrelation("TERMINATE_USER_TASK")
                .setVariable("PARAM 1", "PARAM 2")
                .correlateWithResult();
//        System.out.println(result);
    }
}
