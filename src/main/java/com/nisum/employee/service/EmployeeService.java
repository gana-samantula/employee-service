package com.nisum.employee.service;

import com.nisum.employee.model.Employee;
import com.nisum.employee.repository.EmployeeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeServiceRepository employeeServiceRepository;

    public List<Employee> findAllEmployees() {
        return employeeServiceRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeServiceRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeServiceRepository.findById(employeeId);
    }

    public void deleteEmployee(Long employeeId){
        Optional<Employee> employee = getEmployeeById(employeeId);
        if(employee.isPresent()){
            employeeServiceRepository.deleteById(employeeId);
        }else{
            System.out.println("EmployeeListService:deleteEmployee(): Employee is not available to be deleted:");
        }
    }

    public Employee updateEmployee(Long employeeId, Employee updatedEmp){
        Optional<Employee> employee = getEmployeeById(employeeId);

        if(employee.isPresent()){
            Employee updateEmployee = employee.get();
            updateEmployee.setFirstName(updatedEmp.getFirstName());
            updateEmployee.setLastName(updatedEmp.getLastName());
            updateEmployee.setEmailId(updatedEmp.getEmailId());
            return employeeServiceRepository.save(updateEmployee);
        }else{
            System.out.println("EmployeeService:updateEmployee() Employee is not available to update:");
        }
        return updatedEmp;
    }


}
