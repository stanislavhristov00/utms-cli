package com.vmware.services;

import com.vmware.entities.Project;
import com.vmware.entities.TestRun;
import com.vmware.entities.TestRunPK;
import com.vmware.enums.TestRunStatus;
import com.vmware.models.baseModels.TestRunModel;
import com.vmware.models.baseModels.requestModels.TestRunRequestModel;
import com.vmware.repositories.ProjectRepository;
import com.vmware.repositories.TestRunRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class TestRunService {
    private TestRunRepository testRunRepository;
    private ProjectRepository projectRepository;
    private MappingService mappingService;


    public TestRunService(TestRunRepository testRunRepository, ProjectRepository projectRepository,
                          MappingService mappingService){
        this.testRunRepository = testRunRepository;
        this.projectRepository = projectRepository;
        this.mappingService = mappingService;
    }



    public List<TestRun> findAllByProjectId(Long id){
        return this.testRunRepository.findAllByProjectId(id);
    }

    public TestRunModel findByProjectIdAndTestRunId(Long project_id, Long test_run_id){
        TestRun tr = this.testRunRepository.findByPK(new TestRunPK(project_id, test_run_id));
        return new TestRunModel(tr.getStatus(), MappingService.mapTestSuiteModels(tr.getTestSuites()));
    }

    public TestRun createTestRun(Long project_id){
        Long testRunId = this.testRunRepository.findNextId(project_id);
        Project project = this.projectRepository.findById(project_id).orElse(null);
        if(project != null){
            TestRun tr = new TestRun(new TestRunPK(project_id, testRunId), TestRunStatus.IN_PROGRESS, new HashSet<>(), project);
            this.testRunRepository.save(tr);
            project.addTestRun(tr);
            this.projectRepository.save(project);
            return tr;
        }
        return null;
    }

    public void updateTestRun(TestRun testRun, TestRunRequestModel testRunRequestModel, Project project){
        switch(testRunRequestModel.getStatus()){
            case "passed":
                testRun.setStatus(TestRunStatus.PASSED);
                break;
            case "failed":
                testRun.setStatus(TestRunStatus.FAILED);
                break;
            case "skipped":
                testRun.setStatus(TestRunStatus.SKIPPED);
                break;
        }
        testRun.setTestSuites(this.mappingService.mapTestSuiteRequestModels(testRunRequestModel.getSuites(),testRun));
        this.testRunRepository.save(testRun);
        this.projectRepository.save(project);
    }
}
