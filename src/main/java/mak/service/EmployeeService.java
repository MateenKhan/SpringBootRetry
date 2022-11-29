package mak.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import mak.pojo.Employee;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeService {

    RestTemplate restTemplate;

    public Employee save(Employee employee) {
        return restTemplate.postForObject("http://localhost:8080/employees/", employee, Employee.class);
    }

    public void delete(Employee employee) {
        restTemplate.delete("http://localhost:8080/employees/" + employee.getId(), Optional.class);
    }

    public Optional<Employee> get(Integer id) {
        return restTemplate.getForObject("http://localhost:8080/employees/" + id, Optional.class);
    }

    @Retryable(value = Exception.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
    public List<Employee> findAll() {
        System.out.println("**********************************************************");
        System.out.println("starting find all:");
        System.out.println("**********************************************************");
        return restTemplate.getForObject("http://localhost:8080/employees", List.class);
    }

    @Recover
    public List<Employee> recover(Exception e) {
        System.out.println("**********************************************************");
        System.out.println("recover:");
        e.printStackTrace();
        System.out.println("**********************************************************");
        return null;
    }
}
