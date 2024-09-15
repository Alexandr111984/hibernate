package com.netology.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "person", schema = "netology")
public class Person {
    @Column
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "surname")
    private String surname;

    @Id
    @Column(name = "age")
    @JsonIgnore
    private int age;

    @Column(name = "phone_number")
    @JsonIgnore
    private String phoneNumber;

    @Column(name = "city_of_living")
    @JsonIgnore
    private String cityOfLiving;

}

