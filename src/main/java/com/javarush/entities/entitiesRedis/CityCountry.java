package com.javarush.entities.entitiesRedis;


import com.javarush.entities.entitiesTables.City;
import com.javarush.entities.entitiesTables.Continent;
import com.javarush.entities.entitiesTables.Country;
import com.javarush.entities.entitiesTables.CountryLanguage;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class CityCountry {


    private Integer idCity;

    private String nameCity;

    private String district;

    private Integer population;

    private Integer idCountry;

   private String codeCountry;

     private String codeCountryTwo;

    private String nameCountry;

    private Continent continent;

    private String region;

    private BigDecimal surface_area;


    private Short indepYear;

    private Integer countryPopulation;

    private Set<CountryLanguage> languages;




}
