package com.example.workflow.mvc.delegates.grupa4;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

@Component
public class Grupa4VariableMapper implements DelegateVariableMapping {
    @Override
    public void mapInputVariables(DelegateExecution delegateExecution, VariableMap variableMap) {
        for (String key : delegateExecution.getVariables().keySet()) {
            variableMap.put(key, delegateExecution.getVariable(key));
        }
    }

    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope) {
        delegateExecution.setVariables(variableScope.getVariables());
    }
}
