package com.vmware.repositories;

import com.vmware.entities.TestRun;
import com.vmware.entities.TestRunPK;
import com.vmware.models.baseModels.TestRunModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRunRepository extends JpaRepository<TestRun, TestRunPK> {
    /*@Query(nativeQuery = true, value = "select test_run_id from test_run where project_id = ?1")
    public List<Long> getIdByProjectId(Long id);*/

    @Query(nativeQuery = true, value= "select count(*) + 1 from test_run where project_id = ?1")
    public Long findNextId(Long id);

    @Query(value = "select t from TestRun t where t.id = ?1")
    public TestRun findByPK(TestRunPK testRunPK);

    public List<TestRun> findAllByProjectId(Long id);
}
