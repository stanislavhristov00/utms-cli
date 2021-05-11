package com.vmware.services;

import com.vmware.entities.TestCase;
import com.vmware.entities.TestSuite;
import com.vmware.models.baseModels.TestCaseModel;
import com.vmware.models.baseModels.TestSuiteModel;

import java.util.HashSet;
import java.util.Set;

public class MappingService {
    public static Set<TestCaseModel> mapTestCaseModels(Set<TestCase> testCases){
        Set<TestCaseModel> result = new HashSet<>();
        for(TestCase t : testCases){
            TestCaseModel temp = new TestCaseModel(t.getId().getName(), t.getStatus());
            result.add(temp);
        }
        return result;
    }

    public static Set<TestSuiteModel> mapTestSuiteModels(Set<TestSuite> testSuites){
        Set<TestSuiteModel> result = new HashSet<>();
        for(TestSuite t : testSuites){
            TestSuiteModel temp = new TestSuiteModel(t.getId().getName(),
                    mapTestCaseModels(t.getTestCases()));
            result.add(temp);
        }
        return result;
    }
}
