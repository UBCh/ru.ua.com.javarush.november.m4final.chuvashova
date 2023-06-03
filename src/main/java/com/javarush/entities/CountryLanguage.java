package com.javarush.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "country_language")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class CountryLanguage {

    public CountryLanguage(Country country, String language, int isOfficial, long percentage) {
        this.country = country;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idLanguage;


    @OneToOne
    @JoinColumn(name="country_id",insertable = false, updatable = false, columnDefinition = "TINYINT")
    public Country country;


    @Column(name = "language", length=30, nullable = false)
    String language;

    @Column(name = "is_official",  nullable = false, columnDefinition = "TINYINT" )
    int isOfficial;

    @Column(name = "percentage",  nullable = false)
    long percentage;
}
