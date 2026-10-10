package sk.ukf.employee_directory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.ukf.employee_directory.dao.EmployeeDAO;
import sk.ukf.employee_directory.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
