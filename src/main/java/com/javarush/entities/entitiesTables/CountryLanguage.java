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



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private Integer idLanguage;




    @ManyToOne
    @JoinColumn(name="country_id",insertable = false, updatable = false, columnDefinition = "TINYINT")
    private Country country;


    @Column(name = "language", length=30, nullable = false)
    private String language;


    @Column(name = "is_official",  nullable = false, columnDefinition = "BIT" )
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    public Boolean isOfficial;


    @Column(name = "percentage",  nullable = false)
    private BigDecimal percentage;
}
