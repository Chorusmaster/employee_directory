package sk.ukf.employee_directory.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.ukf.employee_directory.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
