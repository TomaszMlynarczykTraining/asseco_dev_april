package com.example.workflow.mvc.delegates.grupa3;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentMapperDelegate implements DelegateVariableMapping {


    @Override
    public void mapInputVariables(DelegateExecution delegateExecution, VariableMap variableMap) {
        Map<String, Object> variables = delegateExecution.getVariables();
        Object object = variables.get("zloty");
        if(object != null){
            variableMap.put("zloty", object);
        }
        variableMap.put("euro", 100);
    }

    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope) {
        Map<String, Object> variables = variableScope.getVariables();
        delegateExecution.setVariables(variables);
    }
}
