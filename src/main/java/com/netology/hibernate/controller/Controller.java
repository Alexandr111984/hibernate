package com.netology.hibernate.controller;

import com.netology.hibernate.entity.Persons;
import com.netology.hibernate.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private final PersonsService personsService;

    public Controller(PersonsService personsService) {

        this.personsService = personsService;
    }

    @GetMapping("/persons/by-cityOfLiving")
    public List<Persons> getPersons(@RequestParam("cityOfLiving") String cityOfLiving) {

        return personsService.getByCityOfLiving(cityOfLiving);
    }

    @GetMapping("/persons/by-age")
    public List<Persons> getPersons(@RequestParam("age") Integer age) {

        return personsService.getByAgeLessThan(age);
    }

    @GetMapping(value = "/persons/by")
    public Optional<Persons> getPersons(@RequestParam("name") String name, @RequestParam("surname") String surname) {

        return personsService.getByNameAndSurname(name, surname);
    }


}

