package com.netology.hibernate.repository;

import com.netology.hibernate.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PersonsRepository extends JpaRepository<Persons, Integer> {

    @Query("select p from Persons p where p.city_of_living = :city_of_living")
    List<Persons> findByCity_of_living(@Param("city_of_living") String city_of_living);

    @Query("select p from Persons p where p.age < :age")
    List<Persons> findByAgeLessThan(@Param("age") int age);

    @Query("select p from Persons p where p.name = :name and p.surname = :surname")
    Optional<Persons> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);


}