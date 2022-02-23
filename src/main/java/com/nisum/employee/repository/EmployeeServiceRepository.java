package com.nisum.employee.repository;

import com.nisum.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeServiceRepository extends JpaRepository<Employee, Long> {

}
