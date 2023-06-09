package com.javarush.entities.entitiesH2DB;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "countryH2DB")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CountryH2DB {


    @Id
    @Column(name = "id", length = 5)

    private long id;

    @Column(length = 20)
    private String name;

    @Column(length = 55)
    private String region;


    @Column
    private long population;


    @Column(name = "capital")
    private long cityId;


    @Column(name = "language")
    private long languagesId;

}
