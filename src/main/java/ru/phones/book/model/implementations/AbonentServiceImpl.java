package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.*;
import ru.phones.book.model.repositories.*;
import ru.phones.book.model.services.AbonentService;


@Service
public class AbonentServiceImpl implements AbonentService {

    private Abonent abonent;
    private AbonentRepository abonentRepository;
    private AddressRepository addressRepository;
    private DepartamentRepository departamentRepository;
    private EmployeeRepository employeeRepository;
    private PhoneNumbersRepository phoneNumbersRepository;
    private PositionRepository positionRepository;

    @Autowired
    public AbonentServiceImpl(Abonent abonent, AbonentRepository abonentRepository, AddressRepository addressRepository, DepartamentRepository departamentRepository, EmployeeRepository employeeRepository, PhoneNumbersRepository phoneNumbersRepository, PositionRepository positionRepository) {
        this.abonent = abonent;
        this.abonentRepository = abonentRepository;
        this.addressRepository = addressRepository;
        this.departamentRepository = departamentRepository;
        this.employeeRepository = employeeRepository;
        this.phoneNumbersRepository = phoneNumbersRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public AbonentView addAbonent(AbonentView abonentView) {
        
        return null;
    }

    @Override
    public void deleteAbonentById(Long abonentId) {

    }

    @Override
    public void updateAbonent(Abonent abonent) {

    }
}
