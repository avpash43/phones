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

    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private AbonentRepository abonentRepository;
    @Autowired private AddressRepository addressRepository;
    @Autowired private DepartamentRepository departamentRepository;
    @Autowired private PhoneNumbersRepository phoneNumbersRepository;
    @Autowired private PositionRepository positionRepository;

    @Test
    public void injectedEmployeeAreNotNull(){
        assertThat(employeeRepository).isNotNull();
    }

    @Test
    public void injectedAddressAreNotNull(){
        assertThat(addressRepository).isNotNull();
    }

    @Test
    public void injectedAbonentAreNotNull(){
        assertThat(abonentRepository).isNotNull();
    }

    @Test
    public void injectedDepartamentAreNotNull(){
        assertThat(departamentRepository).isNotNull();
    }

    @Test
    public void injectedPhoneNumbersAreNotNull(){
        assertThat(phoneNumbersRepository).isNotNull();
    }

    @Test
    public void injectedPositionAreNotNull(){
        assertThat(positionRepository).isNotNull();
    }
}
