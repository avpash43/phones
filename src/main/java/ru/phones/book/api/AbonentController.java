package ru.phones.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.AbonentView;
import ru.phones.book.model.services.AbonentService;
import ru.phones.book.model.services.AbonentViewService;

import java.util.List;

@RestController
@RequestMapping(path="/api/abonent", produces="application/json")
public class AbonentController {
    private final AbonentViewService abonentViewService;
    private final AbonentService abonentService;

    @Autowired
    public AbonentController(AbonentViewService abonentViewService, AbonentService abonentService) {
        this.abonentViewService = abonentViewService;
        this.abonentService = abonentService;
    }

    @GetMapping("/get")
    public List<AbonentView> getAll() {
        return abonentViewService.findAll();
    }

    @GetMapping("/get/id/{abonentId}")
    public ResponseEntity<AbonentView> getById(@PathVariable(name="abonentId")Long abonentId) {
        return abonentViewService.findById(abonentId);
    }

    @GetMapping("/get/lastname/{abonentLastname}")
    public ResponseEntity<AbonentView> getById(@PathVariable(name="abonentLastname")String abonentLastname) {
        return abonentViewService.findByLastname(abonentLastname);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public AbonentView addEmployee(@RequestBody AbonentView abonentView) {
        AbonentView abonent = abonentViewService.findByLastnameAndFirstname(abonentView.getLastname(), abonentView.getFirstname()).getBody();

        if (abonent == null) {
            return abonentService.addAbonent(abonentView);
        }
        return abonent;
    }
}