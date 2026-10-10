package sk.ukf.employee_directory.service;

import sk.ukf.employee_directory.entity.Employee;
import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
}
