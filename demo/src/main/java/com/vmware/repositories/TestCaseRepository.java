package com.vmware.repositories;

import com.vmware.entities.TestCase;
import com.vmware.entities.TestCasePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, TestCasePK> {
}
