package com.example.workflow.mvc.delegates.grupa_2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaZmiennychDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        delegateExecution.setVariable("lista", integers);
    }
}
