package com.example.workflow.mvc.delegates;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PtDelegate implements JavaDelegate {

    @Autowired HistoryService myHistoryService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception{
        var s = delegateExecution.getVariable("Input_pt1");
        delegateExecution.setVariableLocal("zmienna_pt1", "OUT:" + s);

       // myHistoryService.createHistoricJobLogQuery().
    }
}
