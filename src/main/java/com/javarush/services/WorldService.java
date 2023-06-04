package com.javarush.services;


import com.javarush.entities.entitiesTables.City;
import com.javarush.entities.entitiesTables.Country;
import com.javarush.repository.CityRepository;
import com.javarush.repository.CountryRepository;
import com.javarush.dataSource.hibernate.session_provider.PropertiesSessionProvider;
import com.javarush.dataSource.hibernate.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class WorldService {

    private SessionProvider sessionProvider = new PropertiesSessionProvider();
    ;

    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    public WorldService() {
        this.cityRepository = new CityRepository(sessionProvider);
        this.countryRepository = new CountryRepository(sessionProvider);
    }

    private List<City> fetchData() {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            List<City> allCities = new ArrayList<>();
            session.beginTransaction();
            List<Country> countries = countryRepository.getAll();
            int totalCount = cityRepository.getTotalCountCity();
            int step = 500;
            for (int i = 0; i < totalCount; i += step) {
                allCities.addAll(cityRepository.getItems(i, step));
            }
            session.getTransaction().commit();
            return allCities;
        }
    }

}
