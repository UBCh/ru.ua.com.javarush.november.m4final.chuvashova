package com.javarush.entities.H2DB;


import com.javarush.entities.entitiesTables.City;
import com.javarush.entities.entitiesTables.Continent;
import com.javarush.entities.entitiesTables.CountryLanguage;
import jakarta.persistence.*;
import liquibase.datatype.core.VarcharType;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

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
