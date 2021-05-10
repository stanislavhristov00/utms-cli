package com.vmware.repositories;

import com.vmware.entities.TestSuite;
import com.vmware.entities.TestSuitePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestSuiteRepository extends JpaRepository<TestSuite, TestSuitePK> {
}
