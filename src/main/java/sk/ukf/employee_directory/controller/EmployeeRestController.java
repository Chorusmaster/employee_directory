package sk.ukf.employee_directory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import sk.ukf.employee_directory.entity.Employee;
import sk.ukf.employee_directory.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id " + id + " not found");
        }
        return employee;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(null);
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {

        Employee existingEmployee = employeeService.findById(id);
        if (existingEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id " + id + " not found");
        }
        employee.setId(id);
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteEmployee(@PathVariable Integer id) {
        Employee existingEmployee = employeeService.findById(id);

        if (existingEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id " + id + " not found");
        }

        employeeService.deleteById(id);

        return Map.of("message", "Deleted employee with id " + id);
    }
}
