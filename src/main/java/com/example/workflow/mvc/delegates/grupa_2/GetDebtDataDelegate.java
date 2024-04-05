package com.example.workflow.mvc.delegates.grupa_2;

import com.example.workflow.mvc.entity.Client;
import com.example.workflow.mvc.entity.Debt;
import com.example.workflow.mvc.repository.ClientRepository;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetDebtDataDelegate implements JavaDelegate {

    private final ClientRepository clientRepository;

    public GetDebtDataDelegate(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Object clientIdObject = execution.getVariable("clientId");
        if (clientIdObject == null) {
            throw new BpmnError("500", "Nie przekazano ID klienta");
        }

        Optional<Client> client = clientRepository.findById(Long.parseLong(clientIdObject.toString()));
        if (client.isEmpty()) {
            throw new BpmnError("404", "Brak klienta o wskazanym ID w bazie danych");
        }

        Debt debt = client.get().getDebt();
        if (debt == null) {
            execution.setVariable("isDebt", false);
        } else {
            execution.setVariable("isDebt", true);
//            execution.setVariable("isOverdue", debt.getIsOverdue());
//            execution.setVariable("amount", debt.getAmount());
        }
    }

}
