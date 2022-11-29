package mak.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import mak.pojo.Employee;
import mak.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Optional<Employee> get(Integer id) {
        return employeeRepository.findById(id);
    }
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
