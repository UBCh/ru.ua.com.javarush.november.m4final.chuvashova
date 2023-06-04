package com.javarush.entities.entitiesRedis;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@NoArgsConstructor
@Getter
@Setter
@ToString

public class Language {


    private String language;
    private Boolean isOfficial;
    private BigDecimal percentage;
}
