package com.vmware.repositories;

import com.vmware.entities.Project;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT pr FROM Project pr WHERE pr.name = ?1")
    public Project findByName(String name);
}
