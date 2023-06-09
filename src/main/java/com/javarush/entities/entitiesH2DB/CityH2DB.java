package com.javarush.entities.entitiesH2DB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "cityH2DB")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CityH2DB {


    @Id
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(name = "country_id", length = 5)
    private Long countryId;

    @Column(length = 54)
    private String district;

    @Column(length = 10)
    private Long population;

}

