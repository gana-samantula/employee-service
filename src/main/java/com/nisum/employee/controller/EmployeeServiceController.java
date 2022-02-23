package com.nisum.employee.controller;

import com.nisum.employee.model.Employee;
import com.nisum.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeServiceController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employees", produces = {"application/json"})
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping(value = "/employees" , consumes = {"application/json"})
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping(value="/employees/{id}",produces = {"application/json"})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId).get();
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping(value="/employees/{id}",produces = {"application/json"})
    public void deleteEmployee(@PathVariable(value = "id") Long employeeId){
        employeeService.deleteEmployee(employeeId);

    }

    @PutMapping (value="/employees/{id}",produces = {"application/json"})
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,@RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId, employee);
    }

}
