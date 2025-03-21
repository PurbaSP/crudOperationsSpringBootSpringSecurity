package com.example.crudOperationsSpringBoot.controller;

import com.example.crudOperationsSpringBoot.model.AuthRequest;
import com.example.crudOperationsSpringBoot.model.Employee;
import com.example.crudOperationsSpringBoot.service.EmployeeService;
import com.example.crudOperationsSpringBoot.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeServiceApp")
public class EmployeeDetails {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    JwtService jwtService;




    @GetMapping("/welcome")
    public String welcome()
    {
        return "Welcome this enpoint is not secure !!" ;
    }

    // for JWT
    @PostMapping("/authenticate")
    public String authenticateAndGenerateToken(@RequestBody AuthRequest authRequest)
    {
        return jwtService.generateToken(authRequest.getUser());
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee emp)
    {
        return employeeService.createEmployee(emp);
    }

    @PostMapping("/createMultipleEmployees")
    public List<Employee> addEmployees (@RequestBody List<Employee> employees)
    {
        return employeeService.createEmployees(employees);
    }

  @GetMapping("/getEmployeeDetails/{empId}")
public Employee getEmployeeDetailsById(@PathVariable int empId)
{
return employeeService.getEmployeebyID(empId);
}

@GetMapping("/getAllEmployees")
public List<Employee> getAllEmployees()
{
    return employeeService.getAllEmployees();
}

@PutMapping("/updateEmployee")
public String updateEmployee(@RequestBody  Employee emp)
{
    return employeeService.updateEmployee(emp);
}

@DeleteMapping("/deleteEmployee/{empId}")
public String deleteEmployee(@PathVariable int empId)
{
    return employeeService.deleteEmployeeById(empId);
}
}

