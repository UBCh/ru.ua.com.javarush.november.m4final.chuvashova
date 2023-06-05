package com.javarush.entities.entitiesTables;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "world", name = "city")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class City {

    public City(String name, Country country, String district, Integer population) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private String district;

    private Integer population;

}
