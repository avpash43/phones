package ru.phones.book.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.Abonent;
import ru.phones.book.model.entites.AbonentView;
import ru.phones.book.service.AbonentService;
import ru.phones.book.service.AbonentViewService;

@RestController
@RequestMapping("/v1/api/abonent")
@Api(tags = "Abonent")
public class AbonentController {
    private final AbonentViewService abonentViewService;
    private final AbonentService abonentService;

    @Autowired
    public AbonentController(AbonentViewService abonentViewService, AbonentService abonentService) {
        this.abonentViewService = abonentViewService;
        this.abonentService = abonentService;
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Get information about the abonents.")
    public Resources<Resource<AbonentView>> getAll() {

        Resources<Resource<AbonentView>> recentResources = Resources.wrap(abonentViewService.findAll());
        recentResources.add(
                ControllerLinkBuilder.linkTo(AbonentController.class)
                        .slash("get")
                        .withRel("abonents"));

        return recentResources;
        //return abonentViewService.findAll();
    }

    @ApiOperation("Get information about the abonent by id.")
    @GetMapping(path = "/get/id/{abonentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbonentView> getById(@PathVariable("abonentId") @ApiParam(value = "Abonent id", required = true) Long abonentId) {
        return abonentViewService.findById(abonentId);
    }

    @GetMapping(path = "/get/lastname/{abonentLastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Get information about the abonent by lastname.")
    public ResponseEntity<AbonentView> getById(@PathVariable("abonentLastname") @ApiParam(value = "Abonent lastname", required = true) String abonentLastname) {
        return abonentViewService.findByLastname(abonentLastname);
    }

    @PostMapping(path = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create new abonent.")
    public AbonentView addAbonent(@RequestBody @ApiParam(value = "Abonent", required = true) Abonent abonent) {
        return abonentService.addAbonent(abonent);
    }

    @DeleteMapping("/delete/{abonentId}")
    @ApiOperation("Delete abonent.")
    public void deleteAddressById(@PathVariable("abonentId") @ApiParam(value = "Abonent id", required = true) Long abonentId){
        abonentService.deleteAbonentById(abonentId);
    }

    @PutMapping(path="/update/{abonentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Update abonent.")
    public void updateAddress(@RequestBody @ApiParam(value = "Abonent", required = true) Abonent abonent,
                              @PathVariable("abonentId") @ApiParam(value = "Abonent id", required = true) Long abonentId) {
        Abonent emp = abonentService.findById(abonentId);
        if (emp != null && abonent.getId() != null) {
            abonentService.updateAbonent(abonent);
        }
    }
}
