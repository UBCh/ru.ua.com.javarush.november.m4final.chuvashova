package com.javarush.services;


import com.javarush.dataSource.hibernate.session_provider.SessionProvider;

import com.javarush.entities.H2DB.CityH2DB;
import com.javarush.entities.H2DB.CountryH2DB;
import com.javarush.entities.H2DB.CountryLanguageH2DB;
import com.javarush.entities.entitiesTables.City;
import com.javarush.entities.entitiesTables.Country;
import com.javarush.entities.entitiesTables.CountryLanguage;
import com.javarush.repository.CityRepository;
import com.javarush.repository.CountryRepository;
import com.javarush.repository.H2DBRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class H2DBService {

    public SessionFactory sessionFactory;
    private final SessionProvider sessionProvider;
    private H2DBRepository h2DBRepository;

    public H2DBService(SessionProvider sessProvider) {
	this.sessionProvider = sessProvider;
    }


    public void testMysqlData(List<Integer> ids) throws IOException {
	HashMap<Integer,List<Object>> hashMap=new HashMap<>();

	sessionFactory = sessionProvider.getSessionFactory();
	h2DBRepository = new H2DBRepository(sessionFactory);
	try (Session session = sessionProvider.getSessionFactory().openSession()) {
	    session.beginTransaction();
	    for (Integer id : ids) {
		List<Object> list=new ArrayList<>();
		CityH2DB city = h2DBRepository.findByIdCity(id);
		list.add(city);
		CountryH2DB  countryH2DB= h2DBRepository.findByIdCountry(city.getCountryId());
		list.add(countryH2DB);
		CountryLanguageH2DB countryLanguageH2DB=h2DBRepository.findByIdLanguage(countryH2DB.getLanguagesId());
		list.add(countryLanguageH2DB);
		hashMap.put(id,list);
			    }
	    session.getTransaction().commit();
	}
    }








}
