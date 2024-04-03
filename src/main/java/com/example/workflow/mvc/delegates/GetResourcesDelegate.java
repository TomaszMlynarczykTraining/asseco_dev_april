package com.example.workflow.mvc.delegates;

import com.example.workflow.mvc.processes.OfferProcessingProcess;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GetResourcesDelegate implements JavaDelegate {

    @Autowired
    public RuntimeService runtimeService;

    @Autowired
    public TaskService taskService;

    @Autowired
    public HistoryService historyService;

    private static String IS_OFFER_APPLICABLE="isOfferApplicable";
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        //Pobranie danych z procesu
        String processDefinitionId = delegateExecution.getProcessDefinitionId();
        System.out.println(processDefinitionId);
        Boolean variable = (boolean)delegateExecution.getVariable(IS_OFFER_APPLICABLE);

        //Wykonanie logiki biznesowej


        //Ustawienie potrzebnych zmiennych procesowych

        delegateExecution.setVariable("someVariable", "text");

    }
}
