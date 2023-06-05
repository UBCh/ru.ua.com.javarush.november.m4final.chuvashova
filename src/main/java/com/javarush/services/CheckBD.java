package com.javarush.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import java.util.Properties;

public class CheckBD {
    Properties properties;

    public CheckBD() {
	properties = new Properties();
	properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
	properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	properties.put(Environment.URL, "jdbc:mysql://localhost:3306");
	properties.put(Environment.USER, "root");
	properties.put(Environment.PASS, "root");
	properties.put(Environment.HBM2DDL_AUTO, "update");

    }


    public boolean checkBDExistence() {

	SessionFactory sessionFactory = new Configuration().addProperties(properties).buildSessionFactory();
	Query<String> query = sessionFactory.openSession().createNativeQuery("SELECT DATABASE()");
	String result = query.getSingleResult();
	sessionFactory.close();
	if (null == result) {
	    result = "nul";
	}
	return result.equals("world");
    }
}
