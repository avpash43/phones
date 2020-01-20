package ru.phones.book.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.phones.book.model.entites.Employee;
import ru.phones.book.service.EmployeeService;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTests {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setFirstname("test");
        employee.setLastname("testov");
        employeeService.addEmployee(employee);
        Employee employee2 = employeeService.findByLastname("testov").getBody();
        assertNotNull(employee2);
        assertEquals(employee2.getFirstname(), employee.getFirstname());
        assertEquals(employee2.getLastname(), employee.getLastname());
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setFirstname("test2");
        employee.setLastname("testov2");
        Long employeeId = employeeService.addEmployee(employee).getId();

        Employee employee2 = new Employee();
        employee2.setId(employeeId);
        employee2.setFirstname("test3");
        employee2.setLastname("testov3");
        employeeService.addEmployee(employee2);

        Employee employee1Updated = employeeService.findById(employeeId).getBody();
        assertNotNull(employee1Updated);
        assertEquals(employee2.getFirstname(), employee1Updated.getFirstname());
        assertEquals(employee2.getLastname(), employee1Updated.getLastname());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setFirstname("test4");
        employee.setLastname("testov4");
        Long employeeId = employeeService.addEmployee(employee).getId();
        employeeService.deleteEmployeeById(employeeId);
        Employee deleted = employeeService.findById(employeeId).getBody();
        assertNull(deleted);
    }
}
