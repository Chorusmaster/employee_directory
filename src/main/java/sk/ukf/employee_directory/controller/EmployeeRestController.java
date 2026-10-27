package sk.ukf.employee_directory.controller;

import jakarta.validation.Valid;
import sk.ukf.employee_directory.response.ResponseFactory;
import sk.ukf.employee_directory.response.ResponseWrapper;
import org.springframework.http.ResponseEntity;

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
    private final ResponseFactory response;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ResponseFactory response) {
        this.employeeService = employeeService;
        this.response = response;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<Employee>>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        return response.ok("Úspešne načítané", employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<Employee>> getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id " + id + " not found");
        }

        return response.ok("Úspešne načítané", employee);
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<Employee>> createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(null);
        Employee savedEmployee = employeeService.save(employee);
        return response.created("Úspešne vytvorené", savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<Employee>> updateEmployee(@PathVariable Integer id, @Valid @RequestBody Employee employee) {

        Employee existingEmployee = employeeService.findById(id);
        if (existingEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id " + id + " not found");
        }
        employee.setId(id);
        Employee savedEmployee = employeeService.save(employee);
        return response.ok("Úspešne aktualizované", savedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper<Void>> deleteEmployee(@PathVariable Integer id) {
        Employee existingEmployee = employeeService.findById(id);

        if (existingEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id " + id + " not found");
        }

        employeeService.deleteById(id);

        return response.ok("Zamestnanec úspešne zmazaný");
    }
}
