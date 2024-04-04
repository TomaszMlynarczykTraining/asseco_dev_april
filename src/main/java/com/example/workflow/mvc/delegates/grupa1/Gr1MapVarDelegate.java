package com.example.workflow.mvc.delegates.grupa1;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

@Component
public class Gr1MapVarDelegate implements DelegateVariableMapping {
    @Override
    public void mapInputVariables(DelegateExecution superExecution, VariableMap subVariables) {
        Integer i = (Integer)superExecution.getVariable("mainVar");
        System.out.println("mainVar = " + i);
        subVariables.put("subVar", i);
    }

    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope) {
        Integer i = (Integer)variableScope.getVariable("subVar") * 2;
        System.out.println("subVar = " + i);
        delegateExecution.setVariable("mainVar2", i);
    }
}
