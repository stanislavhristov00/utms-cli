package com.vmware.repositories;

import com.vmware.entities.TestRun;
import com.vmware.entities.TestRunPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRunRepository extends JpaRepository<TestRun, TestRunPK> {
    public List<TestRunPK> findIdByProjectId(Long id);
}
