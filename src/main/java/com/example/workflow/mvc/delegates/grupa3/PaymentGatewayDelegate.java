package com.example.workflow.mvc.delegates.grupa3;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentGatewayDelegate implements JavaDelegate {

    static String PAYMENT_CARD_KEY = "isCardPayment";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Random random = new Random();
        delegateExecution.setVariable(PAYMENT_CARD_KEY, random.nextBoolean());
    }
}
