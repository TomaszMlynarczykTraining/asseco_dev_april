package com.example.workflow.mvc.delegates.grupa3;

import com.example.workflow.mvc.repository.LoanRepository;
import com.example.workflow.mvc.repository.UserRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShortTermLoanDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int clientId =(int) delegateExecution.getVariable("clientId");
        System.out.println(clientId);

        delegateExecution.setVariable("juzBralKredyt", true);


    }
}
