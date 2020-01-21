package ru.phones.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.Abonent;
import ru.phones.book.model.entites.AbonentView;
import ru.phones.book.service.AbonentService;
import ru.phones.book.service.AbonentViewService;

@RestController
@RequestMapping(path="/v1/api/abonent", produces="application/json")
public class AbonentController {
    private final AbonentViewService abonentViewService;
    private final AbonentService abonentService;

    @Autowired
    public AbonentController(AbonentViewService abonentViewService, AbonentService abonentService) {
        this.abonentViewService = abonentViewService;
        this.abonentService = abonentService;
    }

    @GetMapping("/get")
    public Resources<Resource<AbonentView>> getAll() {

        Resources<Resource<AbonentView>> recentResources = Resources.wrap(abonentViewService.findAll());
        recentResources.add(
                ControllerLinkBuilder.linkTo(AbonentController.class)
                        .slash("get")
                        .withRel("abonents"));

        return recentResources;
        //return abonentViewService.findAll();
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
    public AbonentView addAbonent(@RequestBody Abonent abonent) {
        return abonentService.addAbonent(abonent);
    }

    @DeleteMapping("/delete/{abonentId}")
    public void deleteAddressById(@PathVariable(name="abonentId")Long abonentId){
        abonentService.deleteAbonentById(abonentId);
    }

    @PutMapping(path="/update/{abonentId}", consumes="application/json")
    public void updateAddress(@RequestBody Abonent abonent, @PathVariable(name="abonentId")Long abonentId) {
        Abonent emp = abonentService.findById(abonentId);
        if (emp != null && abonent.getId() != null) {
            abonentService.updateAbonent(abonent);
        }
    }
}
