package com.vmware.services;

import com.vmware.entities.*;
import com.vmware.enums.TestCaseStatus;
import com.vmware.enums.TestSuiteStatus;
import com.vmware.models.baseModels.TestCaseModel;
import com.vmware.models.baseModels.TestSuiteModel;
import com.vmware.models.baseModels.requestModels.TestCaseRequestModel;
import com.vmware.models.baseModels.requestModels.TestSuiteRequestModel;
import com.vmware.repositories.TestCaseRepository;
import com.vmware.repositories.TestSuiteRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class MappingService {

    private TestCaseRepository testCaseRepository;
    private TestSuiteRepository testSuiteRepository;

    public MappingService(TestCaseRepository testCaseRepository, TestSuiteRepository testSuiteRepository) {
        this.testCaseRepository = testCaseRepository;
        this.testSuiteRepository = testSuiteRepository;
    }

    public static Set<TestCaseModel> mapTestCaseModels(Set<TestCase> testCases) {
        Set<TestCaseModel> result = new HashSet<>();
        for (TestCase t : testCases) {
            TestCaseModel temp = new TestCaseModel(t.getId().getName(), t.getStatus(),
                    t.getOutput(), t.getError(), t.getStartDate(), t.getEndDate());
            result.add(temp);
        }
        return result;
    }

    public static Set<TestSuiteModel> mapTestSuiteModels(Set<TestSuite> testSuites) {
        Set<TestSuiteModel> result = new HashSet<>();
        for (TestSuite t : testSuites) {
            TestSuiteModel temp = new TestSuiteModel(t.getId().getName(),
                    mapTestCaseModels(t.getTestCases()));
            result.add(temp);
        }
        return result;
    }

    public Set<TestCase> mapTestCaseRequestModels(Map<String, TestCaseRequestModel> tests,
                                                         TestSuite testSuite) {
        Set<TestCase> result = new HashSet<>(); // may need treeSet
        for (Map.Entry<String, TestCaseRequestModel> entry : tests.entrySet()) {
            TestCaseRequestModel testCaseRequestModel = entry.getValue();
            TestCase tmp = new TestCase();
            tmp.setId(new TestCasePK(entry.getKey(), testSuite.getId()));
            tmp.setDescription(testCaseRequestModel.getDescription());
            tmp.setEnabled(testCaseRequestModel.getStatus().equals("passed")
                    || testCaseRequestModel.getStatus().equals("failed"));
            switch (testCaseRequestModel.getStatus()) {
                case "passed":
                    tmp.setStatus(TestCaseStatus.PASSED);
                    break;
                case "failed":
                    tmp.setStatus(TestCaseStatus.FAILED);
                    break;
                case "skipped":
                    tmp.setStatus(TestCaseStatus.SKIPPED);
                    break;
            }
            tmp.setOutput(testCaseRequestModel.getOutput());
            tmp.setStartDate(testCaseRequestModel.getStartDate());
            tmp.setEndDate(testCaseRequestModel.getEndDate());
            tmp.setError(testCaseRequestModel.getError());
            tmp.setTestSuite(testSuite);
            result.add(tmp);
            this.testCaseRepository.save(tmp);
        }
        return result;
    }

    public Set<TestSuite> mapTestSuiteRequestModels(List<TestSuiteRequestModel> testSuites, TestRun testRun){
        Set<TestSuite> result = new HashSet<>();
        for(TestSuiteRequestModel t : testSuites){
            TestSuite tmp = new TestSuite();
            tmp.setId(new TestSuitePK(t.getName(),
                    new TestRunPK(testRun.getId().getProjectId(), testRun.getId().getTestRunId())));
            switch (t.getStatus()){
                case "passed":
                    tmp.setStatus(TestSuiteStatus.PASSED);
                    break;
                case "failed":
                    tmp.setStatus(TestSuiteStatus.FAILED);
                    break;
                case "skipped":
                    tmp.setStatus(TestSuiteStatus.SKIPPED);
                    break;
            }
            this.testSuiteRepository.save(tmp);
            tmp.setTestCases(mapTestCaseRequestModels(t.getTests(), tmp));
            this.testSuiteRepository.save(tmp);
            result.add(tmp);
        }
        return result;
    }
}
