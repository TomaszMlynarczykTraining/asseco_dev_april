package com.example.workflow.mvc.delegates.grupa4;

import com.example.workflow.mvc.entity.Loan;
import com.example.workflow.mvc.service.LoanService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class LoanDelegate implements JavaDelegate {

    @Autowired
    private LoanService loanService;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        List<Long> loanIdList = loanService.getAllLoans()
                .stream()
                .map( s -> s.getId())
                .collect(Collectors.toList());
        delegateExecution.setVariable("idList", loanIdList);

    }
}
