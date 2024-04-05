package com.example.workflow.mvc.delegates.grupa1;

import com.example.workflow.mvc.entity.Client;
import com.example.workflow.mvc.service.ClientService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateUserData implements JavaDelegate {

    @Autowired
    ClientService clientService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Client we = new Client();
        we.setStreet((String)delegateExecution.getVariable("street"));
        we.setPhoneNumber((String)delegateExecution.getVariable("phoneNumber"));
        we.setDeclaredIncome((String)delegateExecution.getVariable("declaredIncome"));
        we.setCurrency((String)delegateExecution.getVariable("currency"));

        Long id = (Long)delegateExecution.getVariable("userIdNumber");
        Client client = clientService.getClient(id);

        if (client == null ) {
            throw new RuntimeException("Nie ma takiego klienta");
        }
        boolean correct = client.getStreet().equals(we.getStreet())
                && client.getPhoneNumber().equals(we.getPhoneNumber())
                && client.getDeclaredIncome().equals(we.getDeclaredIncome())
                && client.getCurrency().equals(we.getCurrency());
        delegateExecution.setVariable("dataCorrect", correct);
    }
}
