package com.example.workflow.mvc.delegates.grupa_2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class OcenWnioskuVariableMapper implements DelegateVariableMapping {
    @Override
    public void mapInputVariables(DelegateExecution superExecution, VariableMap subVariables) {
        Map<String, Object> variables = superExecution.getVariables();
        subVariables.put("nadgodzinyPracownikaSub", variables.get("nadgodzinyPracownika"));
    }

    @Override
    public void mapOutputVariables(DelegateExecution superExecution, VariableScope subInstance) {
        Map<String, Object> variables = subInstance.getVariables();
        superExecution.setVariable("czyJestAkceptacja", variables.get("czyJestAkceptacja"));

    }
}
