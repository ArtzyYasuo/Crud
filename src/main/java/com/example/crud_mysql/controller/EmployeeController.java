package com.example.crud_mysql.controller;

import com.example.crud_mysql.model.dto.EmployeeDto;
import com.example.crud_mysql.model.entity.Employee;
import com.example.crud_mysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get_emp")
    public EmployeeDto getEmployeeById(@RequestParam("id") Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/save_emp")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto dto){
        return employeeService.saveEmployee(dto);
    }

    @PutMapping("/update_emp")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto dto){
        return employeeService.updateEmployee(dto);
    }
    @DeleteMapping("/delete_emp")
    public void deleteEmployee(Integer id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/get_all")
    public List<Employee> getAllEmployees(){
       return employeeService.getAllEmployees();
    }
}
