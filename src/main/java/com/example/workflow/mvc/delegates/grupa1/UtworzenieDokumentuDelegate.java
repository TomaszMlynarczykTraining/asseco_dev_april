package com.example.workflow.mvc.processes.grupa1;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.workflow.mvc.processes.OfferProcessingProcess.L_ZAKS_DOSTAW;

@Component
public class UtworzenieDokumentuDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        delegateExecution.setVariable(L_ZAKS_DOSTAW,1L );

    }
}
