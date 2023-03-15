package com.example.crud_mysql.model.dto;

import com.example.crud_mysql.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private Double salary;

    //convert Entity to Dto
    public EmployeeDto convertEntityToDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstname(employee.getFirstName())
                .lastname(employee.getLastName())
                .salary(employee.getSalary())
                .build();
    }
}
