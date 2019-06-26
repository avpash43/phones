package ru.phones.book.model.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.phones.book.model.repositories.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoriesTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    private AbonentRepository abonentRepository;
    private AddressRepository addressRepository;
    private DepartamentRepository departamentRepository;
    private PhoneNumbersRepository phoneNumbersRepository;
    private PositionRepository positionRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        assertThat(employeeRepository).isNotNull();
        assertThat(abonentRepository).isNotNull();
        assertThat(departamentRepository).isNotNull();
        assertThat(phoneNumbersRepository).isNotNull();
        assertThat(positionRepository).isNotNull();
        assertThat(addressRepository).isNotNull();
    }
}
