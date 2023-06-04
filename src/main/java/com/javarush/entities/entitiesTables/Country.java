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


    public Country(String codeCountry, String codeCountryTwo, String nameCountry, Continent continent, String region, BigDecimal surface_area, Short indepYear, Integer population, BigDecimal lifeExpectancy, BigDecimal gnp, BigDecimal gnpoId, String localName, String governmentForm, String headOfState, Set<CountryLanguage> languages) {
        this.codeCountry = codeCountry;
        this.codeCountryTwo = codeCountryTwo;
        this.nameCountry = nameCountry;
        this.continent = continent;
        this.region = region;
        this.surface_area = surface_area;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpoId = gnpoId;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.languages = languages;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCountry;


    @Column(name = "code", length=3, nullable = false)
   private String codeCountry;

    @Column(name = "code_2", length=2, nullable = false)
   private String codeCountryTwo;

    @Column(name = "name", length=52, nullable = false)
    private String nameCountry;

    @Column(name = "continent", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Continent continent;


    @Column(name = "region", length=26, nullable = false)
    String region;

    @Column(name = "surface_area", nullable = false)
    private BigDecimal surface_area;


    @Column(name = "indep_year")
    private Short indepYear;


    @Column(name = "population", nullable = false)
    private Integer population;


    @Column(name = "life_expectancy")
    private BigDecimal  lifeExpectancy;

    @Column(name = "gnp")
    private BigDecimal  gnp;

    @Column(name = "gnpo_id")
    private BigDecimal gnpoId;

    @Column(name = "local_name", length=45, nullable = false)
    private String localName;

    @Column(name = "government_form", length=45, nullable = false)
   private String governmentForm;

    @Column(name = "head_of_state", length=60)
   private String headOfState;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Set<CountryLanguage> languages;

    @OneToOne
    @JoinColumn(name="capital",insertable = false, updatable = false, columnDefinition = "TINYINT", nullable = false)
    public City city;


}
