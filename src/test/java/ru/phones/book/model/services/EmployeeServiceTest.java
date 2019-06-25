package ru.phones.book.model.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.phones.book.model.Employee;
import ru.phones.book.model.repositories.EmployeeRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        employeeRepository.findAll().forEach(x -> System.out.println(x.toString()));

    }
}
