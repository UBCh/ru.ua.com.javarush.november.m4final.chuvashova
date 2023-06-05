package com.javarush.repository;

import com.javarush.entities.entitiesTables.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CountryRepository implements RepositoryEntities<Country> {

    SessionFactory sessionFactory;

    public CountryRepository(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    public List<Country> getAll() {

	try (
		Session session = sessionFactory.openSession()) {
	    Query<Country> query = session.createQuery("select c from Country c join fetch c.languages", Country.class);
	    return query.list();
	}
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(Country tableEntity) {

    }

    @Override
    public void update(Country tableEntity) {

    }

    @Override
    public Country findById(Integer id) {
	return null;
    }
}
