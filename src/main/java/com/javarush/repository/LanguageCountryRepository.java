package com.javarush.repository;

import com.javarush.entities.entitiesTables.CountryLanguage;
import com.javarush.dataSource.hibernate.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class LanguageCountryRepository implements RepositoryEntities <CountryLanguage>{

    SessionFactory sessionFactory;

    public LanguageCountryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<CountryLanguage> getAll() {

        try(
                Session session=sessionFactory.openSession()) {
            Query<CountryLanguage> query = session.createQuery("from CountryLanguage ", CountryLanguage.class);
            return query.list();
        }}




    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(CountryLanguage tableEntity) {

    }

    @Override
    public void update(CountryLanguage tableEntity) {

    }

    @Override
    public CountryLanguage findById(Integer id) {
	return null;
    }
}
