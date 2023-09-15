package neo.ehsanodyssey.jackson.generals.jsonidentityinfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    List<Manager> managers = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();

    {
        Manager manager1 = new Manager(1L, "Ehsan");
        Manager manager2 = new Manager(2L, "Mohammad");
        Manager manager3 = new Manager(3L, "Arash");

        Employee employee1 = new Employee(5L, "Pari", manager1);
        Employee employee2 = new Employee(6L, "Abdoli", manager2);
        Employee employee3 = new Employee(7L, "Karamali", manager3);
        Employee employee4 = new Employee(8L, "Parastoo", manager1);
        Employee employee5 = new Employee(9L, "Mozhgan", manager1);

        manager1.setEmployees(Arrays.asList(employee1,employee4,employee5));
        manager2.setEmployees(Arrays.asList(employee2));
        manager3.setEmployees(Arrays.asList(employee3));

        managers.add(manager1);
        managers.add(manager2);
        managers.add(manager3);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
    }

    private long nextId() {
        return employees.size() + 1L;
    }

    @GetMapping(path = "/manager")
    public ResponseEntity getManagers() {
        return ResponseEntity.ok(managers);
    }

    @GetMapping(path = "/employee")
    public ResponseEntity getEmployees() {
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/manager/{id}")
    public ResponseEntity getManager(@PathVariable Long id) {
        return ResponseEntity.ok(managers.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employees.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }

    @PostMapping("/employee")
    public ResponseEntity saveEmployee(@RequestBody Employee employee) {
        try {
            employee.setId(nextId());
            employees.add(employee);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
