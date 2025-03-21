package com.example.crudOperationsSpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
 public class Employee {

@Id
@GeneratedValue
    private  int empId;
    private String empName;
    private String department;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public Employee() {
    }

    public Employee(int empId, String department, String empName) {
        this.empId = empId;
        this.department = department;
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
