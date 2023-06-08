package com.javarush.services;


import com.javarush.dataSource.hibernate.session_provider.SessionProvider;

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
import java.util.List;
import java.util.Set;

public class H2DBService {

    public SessionFactory sessionFactory;
    private final SessionProvider sessionProvider;

    public H2DBService(SessionProvider sessProvider) {
	this.sessionProvider = sessProvider;
    }






    public  void shouBD() throws IOException {
	sessionFactory = sessionProvider.getSessionFactory();
	H2DBRepository h2DBRepository=new H2DBRepository(sessionFactory);
//	h2DBRepository.shouBD();
    }




}
