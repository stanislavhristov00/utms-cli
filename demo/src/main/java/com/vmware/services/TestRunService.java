package com.vmware.services;

import com.vmware.entities.TestCase;
import com.vmware.entities.TestRun;
import com.vmware.entities.TestRunPK;
import com.vmware.entities.TestSuite;
import com.vmware.models.TestCaseModel;
import com.vmware.models.TestRunModel;
import com.vmware.models.TestSuiteModel;
import com.vmware.repositories.TestRunRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class TestRunService {
    private TestRunRepository testRunRepository;

    public TestRunService(TestRunRepository testRunRepository){
        this.testRunRepository = testRunRepository;
    }

    private Set<TestCaseModel> mapTestCaseModels(Set<TestCase> testCases){
        Set<TestCaseModel> result = new HashSet<>();
        for(TestCase t : testCases){
            TestCaseModel temp = new TestCaseModel(t.getId().getName(), t.getDescription(),
                    t.isEnabled(), t.getStatus(), t.getOutput(),
                    t.getStartTime(), t.getEndTime(), t.getError());
            result.add(temp);
        }
        return result;
    }

    private Set<TestSuiteModel> mapTestSuiteModels(Set<TestSuite> testSuites){
        Set<TestSuiteModel> result = new HashSet<>();
        for(TestSuite t : testSuites){
            TestSuiteModel temp = new TestSuiteModel(t.getId().getName(), t.getStatus(),
                    mapTestCaseModels(t.getTestCases()));
            result.add(temp);
        }
        return result;
    }

    public List<TestRunModel> getIdByProjectId(Long id){
        return this.testRunRepository.findAllByProjectId(id).stream().map((testrun) -> {
            return new TestRunModel(testrun.getId().getTestRunId(),
                    testrun.getStatus(), mapTestSuiteModels(testrun.getTestSuites()));
        }).collect(Collectors.toList());
    }
}
