package com.example.workflow;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.camunda.community.mockito.DelegateExpressions;
import org.camunda.community.mockito.ProcessExpressions;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

@Deployment(resources = {
        "processes/trainer_processes/test_process.bpmn"
})
public class SimpleWorkflowTest extends AbstractProcessEngineRuleTest {

    @Test
    public void testHappyPath(){

        DelegateExpressions.registerJavaDelegateMock("mockDelegate");
        MockitoAnnotations.openMocks(this);

        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("Process_0wly7t5");

        assertThat(processInstance).isWaitingAt("Activity_175syi2");

        Task task = taskService().createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        complete(task);

        assertThat(processInstance).hasPassed("Activity_02cbqrz");
        assertThat(processInstance).isEnded();

    }

}
