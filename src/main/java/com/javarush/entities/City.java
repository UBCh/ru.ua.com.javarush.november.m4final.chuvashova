package com.javarush.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "city")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class City  {


    public City(String nameCity, Country country, String district, int population) {
        this.nameCity = nameCity;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCity;


    @Column(name = "name", length=35, nullable = false)
    String nameCity;


    @OneToOne
    @JoinColumn(name="country_id",insertable = false, updatable = false, columnDefinition = "TINYINT")
    public Country country;


    @Column(name = "district", length=20, nullable = false)
    String district;

    @Column(name = "population", nullable = false)
    int population;



}
