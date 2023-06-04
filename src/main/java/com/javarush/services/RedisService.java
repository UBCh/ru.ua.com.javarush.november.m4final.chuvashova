package com.javarush.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.dataSource.RedisClient.RedisClientCreator;
import com.javarush.entities.entitiesRedis.CityCountry;
import com.javarush.entities.entitiesRedis.Language;
import com.javarush.entities.entitiesTables.City;
import com.javarush.entities.entitiesTables.Country;
import com.javarush.entities.entitiesTables.CountryLanguage;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@NoArgsConstructor


public class RedisService {



    private List<CityCountry> transformData(List<City> cities) {
        return cities.stream().map(city -> {
            CityCountry cityCountry = new CityCountry();
            cityCountry.setIdCity(city.getIdCity());
            cityCountry.setNameCity(city.getNameCity());
            cityCountry.setDistrict(city.getDistrict());
            cityCountry.setPopulation(city.getPopulation());
            Country country = city.getCountry();
            cityCountry.setNameCountry(country.getNameCountry());
            cityCountry.setContinent(country.getContinent());
            cityCountry.setCodeCountry(country.getCodeCountry());
            cityCountry.setCodeCountryTwo(country.getCodeCountryTwo());
            cityCountry.setCountryPopulation(country.getPopulation());
            cityCountry.setRegion(country.getRegion());
            cityCountry.setSurface_area(country.getSurface_area());
            Set<CountryLanguage> countryLanguages = country.getLanguages();
            Set<Language> languages = countryLanguages.stream().map(langC -> {
                Language language = new Language();
                language.setLanguage(langC.getLanguage());
                language.setIsOfficial(langC.getIsOfficial());
                language.setPercentage(langC.getPercentage());
                return language;
            }).collect(Collectors.toSet());
            cityCountry.setLanguages(languages);
            return cityCountry;
        }).collect(Collectors.toList());
    }

    private void pushToRedis(List<CityCountry> data) {
        RedisClientCreator creatorRedis=new RedisClientCreator();
        try (StatefulRedisConnection<String, String> connection = creatorRedis.prepareRedisClient().connect()) {
            RedisStringCommands<String, String> sync = connection.sync();
            ObjectMapper mapper = new ObjectMapper();
            for (CityCountry cityCountry : data) {
                try {
                    sync.set(String.valueOf(cityCountry.getIdCity()), mapper.writeValueAsString(cityCountry));

                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
