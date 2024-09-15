package com.netology.hibernate;

import com.netology.hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) {

        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Person> list = new ArrayList<>();
        Person p = Person.builder()
                .name("Alex")
                .surname("Alexis")
                .age(12)
                .cityOfLiving("Moscow")
                .phoneNumber("8-3812-22-10-25")
                .build();
        Person p1 = Person.builder()
                .name("Alexey")
                .surname("Alexis")
                .age(25)
                .cityOfLiving("Omsk")
                .phoneNumber("8-3812-22-10-25")
                .build();
        Person p2 = Person.builder()
                .name("Sergey")
                .surname("Ivanov")
                .age(25)
                .cityOfLiving("Moscow")
                .phoneNumber("8-3812-22-10-58")
                .build();
        list.add(p);
        list.add(p1);
        list.add(p2);
        list.forEach(em::persist);

    }

}
