package com.javarush.entities.entitiesTables;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(schema = "world", name = "country_language")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class CountryLanguage {

    public CountryLanguage(Country country, String language, Boolean isOfficial, BigDecimal percentage) {
        this.country = country;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private String language;

    @Column(name = "is_official", columnDefinition = "BIT")
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private Boolean isOfficial;

    private BigDecimal percentage;

}
