package com.netology.hibernate.service;

import com.netology.hibernate.entity.Persons;
import com.netology.hibernate.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)

public class PersonsServiceImpl implements PersonsService {
    @Autowired
    private PersonsRepository personsRepository;


    @Override
    public List<Persons> getByCity_of_living(String city_of_living) {

        return personsRepository.findByCity_of_living(city_of_living);
    }

    @Override
    public List<Persons> getByAgeLessThan(int age) {

        return personsRepository.findByAgeLessThan(age);
    }

    @Override
    @Transactional
    public void add(Persons persons) {
        personsRepository.save(persons);
    }

    @Override
    public Optional<Persons> getByNameAndSurname(String name, String surname) {

        return personsRepository.findByNameAndSurname(name, surname);
    }
}


