package com.javarush.entities.H2DB;


import com.javarush.entities.entitiesTables.Country;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "country_languageH2DB")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CountryLanguageH2DB {


    @Id
   @Column(name = "id", length = 5)
    private long id;

    @Column(name = "name", length = 15)
    private String language;




}
