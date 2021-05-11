package com.vmware.services;

import com.vmware.entities.TestRun;
import com.vmware.entities.TestRunPK;
import com.vmware.models.baseModels.TestRunModel;
import com.vmware.repositories.TestRunRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestRunService {
    private TestRunRepository testRunRepository;

    public TestRunService(TestRunRepository testRunRepository){
        this.testRunRepository = testRunRepository;
    }



    public List<TestRun> findAllByProjectId(Long id){
        return this.testRunRepository.findAllByProjectId(id);
    }

    public TestRunModel findByProjectIdAndTestRunId(Long project_id, Long test_run_id){
        TestRun tr = this.testRunRepository.findByPK(new TestRunPK(project_id, test_run_id));
        return new TestRunModel(tr.getStatus(), MappingService.mapTestSuiteModels(tr.getTestSuites()));
    }

    //public void addTestRun()
}
