package com.example.workflow.mvc.delegates.grupa4;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ExternalTaskSubscription("sendMessageGr4")
public class SendMessageExternalTask implements ExternalTaskHandler {
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        Double wynik = 0.0;
        Double usdToPlnRatio = 3.50;
        System.out.println("Start external task ======================");

        Map<String, Object> variables = externalTask.getAllVariables();
        System.out.println(variables);

        String currency = (String) variables.get("currency");
        Long amount = (Long) variables.get("amount");

        if (currency.equals("USD")) {
            wynik = usdToPlnRatio * amount;
            variables.put("wynik", wynik);
            externalTaskService.complete(externalTask, variables);
        } else {
            wynik = null;
            externalTaskService.handleFailure(externalTask, "Nieobslugiwana waluta",
                    "Tylko akceptujemy USD", 0, 2);

        }



    }
}
