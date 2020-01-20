package ru.phones.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.AbonentView;
import ru.phones.book.repository.AbonentViewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AbonentViewService {

    @Autowired
    AbonentViewRepository abonentViewRepository;

    public List<AbonentView> findAll() {
        return abonentViewRepository.findAll();
    }

    public ResponseEntity<AbonentView> findById(Long abonentViewId) {
        Optional<AbonentView> optAbonentView = abonentViewRepository.findById(abonentViewId);
        return getAbonentViewResponseEntity(optAbonentView);
    }

    public ResponseEntity<AbonentView> findByLastname(String abonentViewLastname) {
        Optional<AbonentView> optAbonentView = abonentViewRepository.findByLastname(abonentViewLastname);
        return getAbonentViewResponseEntity(optAbonentView);
    }

    public ResponseEntity<AbonentView> findByLastnameAndFirstname(String abonentViewLastname, String abonentViewFirstname) {
        Optional<AbonentView> optAbonentView = abonentViewRepository.findByLastnameAndFirstname(abonentViewLastname, abonentViewFirstname);
        return getAbonentViewResponseEntity(optAbonentView);
    }

    private ResponseEntity<AbonentView> getAbonentViewResponseEntity(Optional<AbonentView> optAbonentView) {
        if(optAbonentView.isPresent()) {
            return new ResponseEntity<>(optAbonentView.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
