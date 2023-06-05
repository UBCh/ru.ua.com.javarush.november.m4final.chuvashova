package com.javarush.dataSource.hibernate.session_provider;


import com.javarush.entities.entitiesTables.City;
import com.javarush.entities.entitiesTables.Country;
import com.javarush.entities.entitiesTables.CountryLanguage;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@NoArgsConstructor

public class PropertiesSessionProvider implements SessionProvider {


    @Override
    public SessionFactory getSessionFactory() {

	return new Configuration()
		.addAnnotatedClass(City.class)
		.addAnnotatedClass(Country.class)
		.addAnnotatedClass(CountryLanguage.class)
		.buildSessionFactory();
    }
}