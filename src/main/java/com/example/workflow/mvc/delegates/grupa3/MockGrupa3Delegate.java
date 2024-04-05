package com.example.workflow.mvc.delegates.grupa3;


import com.example.workflow.mvc.entity.Client;
import com.example.workflow.mvc.service.ClientService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MockGrupa3Delegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

//        List<String> imiona = List.of("Mateusz", "Szymon", "Mariusz", "Jarek");
        List<String> imiona = List.of("Jarek");

        delegateExecution.setVariable("programisci", imiona);




    }
}