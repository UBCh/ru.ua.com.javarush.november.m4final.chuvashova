package com.javarush.entities.entitiesTables;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(schema = "world", name = "country")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Country {

    public Country(String code, String alternativeCode, String name, Continent continent, String region, BigDecimal surfaceArea, Short independenceYear, Integer population, BigDecimal lifeExpectancy, BigDecimal GNP, BigDecimal GNPOId, String localName, String governmentForm, String headOfState, City city, Set<CountryLanguage> languages) {
        this.code = code;
        this.alternativeCode = alternativeCode;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.independenceYear = independenceYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOId = GNPOId;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.city = city;
        this.languages = languages;
    }


    @Id
    @Column(name = "id")
    private Integer id;

    private String code;

    @Column(name = "code_2")
    private String alternativeCode;

    private String name;

    @Column(name = "continent")
    @Enumerated(EnumType.ORDINAL)
    private Continent continent;

    private String region;

    @Column(name = "surface_area")
    private BigDecimal surfaceArea;

    @Column(name = "indep_year")
    private Short independenceYear;

    private Integer population;

    @Column(name = "life_expectancy")
    private BigDecimal lifeExpectancy;

    @Column(name = "gnp")
    private BigDecimal GNP;

    @Column(name = "gnpo_id")
    private BigDecimal GNPOId;

    @Column(name = "local_name")
    private String localName;

    @Column(name = "government_form")
    private String governmentForm;

    @Column(name = "head_of_state")
    private String headOfState;

    @OneToOne
    @JoinColumn(name = "capital")
    private City city;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Set<CountryLanguage> languages;



}
