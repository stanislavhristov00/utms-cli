package com.vmware.services;

import com.vmware.entities.TestRun;
import com.vmware.entities.TestRunPK;
import com.vmware.repositories.TestRunRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRunService {
    private TestRunRepository testRunRepository;

    public TestRunService(TestRunRepository testRunRepository){
        this.testRunRepository = testRunRepository;
    }

    public List<TestRunPK> findAllIdByProjectId(Long id){
        return this.testRunRepository.findIdByProjectId(id);
    }
}
