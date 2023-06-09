package com.javarush.entities.entitiesH2DB;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
