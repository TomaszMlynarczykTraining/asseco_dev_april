package com.example.workflow.mvc.delegates.grupa_2;

import com.example.workflow.mvc.repository.LoanRepository;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class GetLoansDataDelegate implements JavaDelegate {

    private final LoanRepository loanRepository;

    public GetLoansDataDelegate(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Object clientIdObject = execution.getVariable("clientId");
        if (clientIdObject == null) {
            throw new BpmnError("500", "Nie przekazano ID klienta");
        }
        int clientId = Integer.parseInt(clientIdObject.toString());

//        Integer loansSum = loanRepository.findAll().stream()
//                .filter(loan -> loan.getClient_id() == clientId)
//                .map(loan -> Integer.parseInt(loan.getAmount()))
//                .reduce(0, Integer::sum);

        boolean isLoan = loanRepository.findAll().stream().anyMatch(loan -> loan.getClient_id() == clientId);

        execution.setVariable("isLoan", isLoan);
    }

}
