package com.javarush.repository;

import com.javarush.entities.entitiesTables.City;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CityRepository implements RepositoryEntities<City> {

    private SessionProvider sessionProvider;

    public CityRepository(SessionProvider sessionProvider) {
        this.sessionProvider = sessionProvider;
    }


    public List<City> getAll() {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        try (
                Session session = sessionFactory.openSession()) {
            Query<City> query = session.createQuery("from City ", City.class);
            return query.list();
        }
    }


    public List<City> getItems(int offset, int limit) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        try (
                Session session = sessionFactory.openSession()) {
            Query<City> query = session.createQuery("from City ", City.class);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        }
    }


    public int getTotalCountCity() {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        try (
                Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("select count(c) from City c", Long.class);
           return Math.toIntExact(query.uniqueResult());
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(City tableEntity) {

    }

    @Override
    public void update(City tableEntity) {

    }

    @Override
    public City findById(Integer id) {
        return null;
    }
}
