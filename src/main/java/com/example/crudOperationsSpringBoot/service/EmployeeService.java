package com.example.crudOperationsSpringBoot.service;

import com.example.crudOperationsSpringBoot.dao.EmployeeRepository;
import com.example.crudOperationsSpringBoot.model.AuthRequest;
import com.example.crudOperationsSpringBoot.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeService {
@Autowired
  private  EmployeeRepository employeeRepository;





public Employee getEmployeebyID(int empId)
{
     return employeeRepository.findById(empId).orElse(null);
}
public Employee createEmployee ( Employee employee)
{
   return  employeeRepository.save(employee);
}
public List<Employee> createEmployees ( List<Employee> employees)
{
       return employeeRepository.saveAll(employees);
}

public List<Employee> getAllEmployees()
{
    return employeeRepository.findAll();
}

public String  updateEmployee(Employee employee)
{

    Optional<Employee> employeeOptional =  employeeRepository.findById(employee.getEmpId());
    if(employeeOptional.isPresent())
    {

        Employee empExist = null;

        empExist = employeeOptional.get();
        empExist.setEmpName(employee.getEmpName());
        empExist.setDepartment(employee.getDepartment());
        empExist.setEmpId(employee.getEmpId());
        employeeRepository.save(empExist);
    }
    else {
       return "Employee with this ID does not exist !! " ;
    }
return "Employee details are updated..";
}

public String deleteEmployeeById ( int empId)
{
    Optional<Employee> employeeOptional =  employeeRepository.findById(empId);
        System.out.println("emp optional =="+employeeOptional);
        if(employeeOptional.isPresent())
        {
            System.out.println("emp exist=="+employeeOptional.get());

            employeeRepository.deleteById(empId);
            return "User was deleted !!";

        }
        else {
            return "User doesnt exist !! ";
        }

    }







}


