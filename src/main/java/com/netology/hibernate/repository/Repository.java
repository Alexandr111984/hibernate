package com.netology.hibernate.repository;

import com.netology.hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager manager;

    public Repository(EntityManager manager) {
        this.manager = manager;
    }

    public List<Person> getPersonsByCity(String city) {
        System.out.println("city " + city);
        return manager.createQuery("SELECT p  FROM Person p" +
                        "    WHERE cityOfLiving =:city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
