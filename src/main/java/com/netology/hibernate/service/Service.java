package com.netology.hibernate.service;

import com.netology.hibernate.entity.Person;
import com.netology.hibernate.repository.Repository;


import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
