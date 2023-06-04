package com.javarush.entities.entitiesTables;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( schema = "world", name = "city")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class City  {

    public City(String nameCity, Country country, String district, Integer population) {
        this.nameCity = nameCity;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCity;


    @Column(name = "name", length=35, nullable = false)
    private String nameCity;


    @ManyToOne
    @JoinColumn(name="country_id",insertable = false, updatable = false, columnDefinition = "TINYINT")
    public Country country;


    @Column(name = "district", length=20, nullable = false)
    private String district;

    @Column(name = "population", nullable = false)
    private Integer population;



}
