package mak.controller;

import io.swagger.annotations.ApiParam;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import mak.pojo.Employee;
import mak.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> get(@ApiParam(value = "id", required = true)@PathVariable("id") Integer id) {
        return employeeService.get(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@ApiParam(value = "id", required = true)@PathVariable("id") Integer id) {
        employeeService.delete(Employee.builder().id(id).build());
    }

}
