package sk.ukf.employee_directory.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.ukf.employee_directory.dao.repository.EmployeeRepository;
import sk.ukf.employee_directory.entity.Employee;
import sk.ukf.employee_directory.exception.EmailAlreadyExistsException;
import sk.ukf.employee_directory.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Zamestnanec", id));
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        // Kontrola duplicitného emailu pri vytváraní nového zamestnanca
        if (employee.getId() == null) {
            if (employeeRepository.existsByEmail(employee.getEmail())) {
                throw new EmailAlreadyExistsException(employee.getEmail());
            }
        } else {
            // Pri aktualizácii skontroluje, či email nepatrí inému zamestnancu
            Employee existingWithEmail = employeeRepository.findByEmail(employee.getEmail()).orElse(null);
            if (existingWithEmail != null && !Objects.equals(existingWithEmail.getId(), employee.getId())) {
                throw new EmailAlreadyExistsException(employee.getEmail());
            }
        }

        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new ObjectNotFoundException("Zamestnanec", id);
        }

        employeeRepository.deleteById(id);
    }
}