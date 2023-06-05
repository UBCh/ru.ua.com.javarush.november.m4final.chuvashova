package com.javarush.services;


import com.javarush.dataSource.hibernate.session_provider.SessionProvider;
import com.javarush.entities.entitiesTables.City;
import com.javarush.entities.entitiesTables.Country;
import com.javarush.entities.entitiesTables.CountryLanguage;
import com.javarush.repository.CityRepository;
import com.javarush.repository.CountryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WorldService {

    public SessionFactory sessionFactory;
    private final SessionProvider sessionProvider;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    public WorldService(SessionProvider sessProvider) {
	this.sessionProvider = sessProvider;
    }


    public List<City> fetchData() {
	sessionFactory = sessionProvider.getSessionFactory();
	countryRepository = new CountryRepository(sessionFactory);
	cityRepository = new CityRepository(sessionFactory);
	try (Session session = sessionFactory.openSession()) {
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

    public void testMysqlData(List<Integer> ids) {
	sessionFactory = sessionProvider.getSessionFactory();
	countryRepository = new CountryRepository(sessionFactory);
	cityRepository = new CityRepository(sessionFactory);
	try (Session session = sessionProvider.getSessionFactory().openSession()) {
	    session.beginTransaction();
	    for (Integer id : ids) {
		City city = cityRepository.findById(id);
		Set<CountryLanguage> languages = city.getCountry().getLanguages();
	    }
	    session.getTransaction().commit();
	}
    }

}
