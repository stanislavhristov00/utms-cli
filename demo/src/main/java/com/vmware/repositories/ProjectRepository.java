package com.vmware.repositories;

import com.vmware.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    //@Query("SELECT pr FROM Project pr WHERE pr.name = ?1")
     Project findByName(String name);

    @Query(nativeQuery = true, value = "select l.project_id + 1 from project as l left outer join project as r on l.project_id + 1 = r.project_id where r.project_id is null limit 1")
    public Long getNextId();
    /*@Query(nativeQuery = true, value = "select count(*) + 1 from project")
    public Long getNextId();*/
}
