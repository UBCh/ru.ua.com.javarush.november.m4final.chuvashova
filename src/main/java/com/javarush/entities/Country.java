package com.javarush.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "country")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Country {


    public Country(String codeCountry, String codeCountryTwo, String nameCountry, int continent, String region, long surface_area, int indepYear, int population, long lifeExpectancy, long gnp, long gnpoId, String localName, String governmentForm, String headOfState, City city) {
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
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCountry;


    @Column(name = "code", length=3, nullable = false)
    String codeCountry;

    @Column(name = "code_2", length=2, nullable = false)
    String codeCountryTwo;

    @Column(name = "name", length=52, nullable = false)
    String nameCountry;

    @Column(name = "continent", nullable = false)
    int continent;


    @Enumerated(EnumType.STRING)
    @Column(name = "region", length=26, nullable = false)
    String region;

    @Column(name = "surface_area", nullable = false)
    long surface_area;


    @Column(name = "indep_year")
    int indepYear;


    @Column(name = "population", nullable = false)
    int population;

    @Column(name = "life_expectancy")
    long  lifeExpectancy;

    @Column(name = "gnp")
    long  gnp;

    @Column(name = "gnpo_id")
    long gnpoId;

    @Column(name = "local_name", length=45, nullable = false)
    String localName;

    @Column(name = "government_form", length=45, nullable = false)
    String governmentForm;

    @Column(name = "head_of_state", length=60)
    String headOfState;


    @OneToOne
    @JoinColumn(name="capital",insertable = false, updatable = false, columnDefinition = "TINYINT", nullable = false)
    public City city;


}
