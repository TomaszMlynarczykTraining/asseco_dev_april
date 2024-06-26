package com.example.workflow.mvc.delegates;


import com.example.workflow.mvc.entity.Client;
import com.example.workflow.mvc.service.ClientService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

@Service
public class MockDelegate implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    ClientService clientService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        //throw new BpmnError("Error_3ldolae", "Some meessage");
        // System.out.println(delegateExecution.getVariable("pizza"));
        // delegateExecution.getSuperExecution().getVariable("pizza");
        // delegateExecution.getVariableLocal("pizza");


        //int loopCounter = (int)delegateExecution.getVariable("loopCounter");
        throw new BpmnError("abc","asd");

        //Random random = new Random();
       //delegateExecution.setVariableLocal("var from st", random.nextInt());

        //System.out.println(runtimeService.getVariable(delegateExecution.getProcessInstanceId(), "pizza"));


    }
}