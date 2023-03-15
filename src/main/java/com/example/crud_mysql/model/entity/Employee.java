package com.example.crud_mysql.model.entity;

import com.example.crud_mysql.model.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer id;
    @Column(name = "first_name")

    private String  firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "salary")
    private Double salary;

    //convert Entity to Dto
    public static Employee convertDtoToEntity(EmployeeDto dto){
        return Employee.builder()
                .id(dto.getId())
                .firstName(dto.getFirstname())
                .lastName(dto.getLastname())
                .salary(dto.getSalary())
                .build();
    }

}
