package com.example.workflow.mvc.delegates.grupa_2;

import com.example.workflow.mvc.entity.Client;
import com.example.workflow.mvc.service.ClientService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PobranieNadgodzinPracownikaDelegate implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    ClientService clientService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        // System.out.println(delegateExecution.getVariable("pizza"));
        // delegateExecution.getSuperExecution().getVariable("pizza");
        // delegateExecution.getVariableLocal("pizza");

//        List<Client> clients = clientService.getClients().stream()
//                .collect(Collectors.toList());

        Integer liczbaNadgodzin = 10;

        delegateExecution.setVariable("nadgodzinyPracownika", liczbaNadgodzin);

        //System.out.println(runtimeService.getVariable(delegateExecution.getProcessInstanceId(), "pizza"));

        System.out.println(delegateExecution.getVariable("nadgodzinyPracownika"));

    }
}
