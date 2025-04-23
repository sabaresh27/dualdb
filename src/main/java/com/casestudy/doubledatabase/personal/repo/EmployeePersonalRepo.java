package com.casestudy.doubledatabase.personal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.doubledatabase.personal.entity.EmployeePersonal;

@Repository
public interface EmployeePersonalRepo extends JpaRepository<EmployeePersonal, Long>{

}
