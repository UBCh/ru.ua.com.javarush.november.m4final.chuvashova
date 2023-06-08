package com.javarush.dataSource.hibernate.session_provider;


import com.javarush.entities.H2DB.CityH2DB;
import com.javarush.entities.H2DB.CountryH2DB;
import com.javarush.entities.H2DB.CountryLanguageH2DB;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import java.util.Properties;

public class PropertiesSessionProviderH2DB implements SessionProvider {

    private Properties properties;


    public PropertiesSessionProviderH2DB() {
	this.properties = new Properties();
	properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
	properties.put(Environment.DRIVER, "org.h2.Driver");
	properties.put(Environment.URL, "jdbc:h2:mem:test");
	properties.put(Environment.USER, "root");
	properties.put(Environment.PASS, "root");
	properties.put(Environment.HBM2DDL_AUTO, "update");
	properties.put(Environment.AUTOCOMMIT,false);
	properties.put(Environment.SHOW_SQL, true);
	properties.put(Environment.FORMAT_SQL, true);
	properties.put(Environment.HIGHLIGHT_SQL, true);

    }

    @Override
    public SessionFactory getSessionFactory() {
	return new Configuration()
		.addProperties(properties)
		.addAnnotatedClass(CityH2DB.class)
		.addAnnotatedClass(CountryH2DB.class)
		.addAnnotatedClass(CountryLanguageH2DB.class)
		.buildSessionFactory();

    }


}
