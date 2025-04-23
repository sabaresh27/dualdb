package com.casestudy.doubledatabase.job.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.doubledatabase.job.entity.EmployeeJob;

@Repository
public interface EmployeeJobRepo extends JpaRepository<EmployeeJob, Long>{

}
