package sk.ukf.employee_directory.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.ukf.employee_directory.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);
    boolean existsByEmail(String email);
}
