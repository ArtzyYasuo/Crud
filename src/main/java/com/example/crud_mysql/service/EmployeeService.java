package com.example.crud_mysql.service;

import com.example.crud_mysql.model.dto.EmployeeDto;
import com.example.crud_mysql.model.entity.Employee;
import com.example.crud_mysql.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("local")
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo repo){
        this.employeeRepo = repo;
    }
    public EmployeeDto getEmployeeById(Integer id){
        Optional<Employee> employee = this.employeeRepo.findById(id);
        if(employee.isPresent())
            return EmployeeDto.convertEntityToDto(employee.get());
        else return null;
    }

    public EmployeeDto saveEmployee(EmployeeDto dto){
        return EmployeeDto
                .convertEntityToDto(employeeRepo.save(Employee.convertDtoToEntity(dto)));
    }

    public void deleteEmployee(Integer id){
        this.employeeRepo.deleteById(id);
    }

    public EmployeeDto updateEmployee(EmployeeDto dto){
        return EmployeeDto
                .convertEntityToDto(employeeRepo.save(Employee.convertDtoToEntity(dto)));
    }

    public List<Employee> getAllEmployees(){
        return this.employeeRepo.findAll();
    }
}
