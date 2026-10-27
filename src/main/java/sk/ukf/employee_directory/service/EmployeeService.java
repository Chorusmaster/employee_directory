package sk.ukf.employee_directory.service;

import sk.ukf.employee_directory.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(Integer id);

    public Employee save(Employee employee);

    public void deleteById(Integer id);
}
