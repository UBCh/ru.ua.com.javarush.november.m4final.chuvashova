package com.javarush.repository;

import com.javarush.entities.H2DB.CityH2DB;
import com.javarush.entities.H2DB.CountryH2DB;
import com.javarush.entities.H2DB.CountryLanguageH2DB;
import com.javarush.entities.entitiesTables.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class H2DBRepository implements RepositoryEntities{

   private String path="src/main/resources/data.sql";




    static SessionFactory sessionFactory;

    public H2DBRepository(SessionFactory sessionFactory) throws IOException {
	this.sessionFactory = sessionFactory;
	runSqlScriptFile(path);
    }

     private void runSqlScriptFile(String p) throws IOException {
	String sqlScript = new String(Files.readAllBytes(Paths.get(p)));
	SessionFactory scriptSessionFactory = sessionFactory;
	Session scriptSession = scriptSessionFactory.openSession();
	scriptSession.beginTransaction();

	NativeQuery nativeQuery = scriptSession.createNativeQuery(sqlScript);
	nativeQuery.executeUpdate();

	scriptSession.getTransaction().commit();}





    @Override
    public List getAll() {
	return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(Object tableEntity) {

    }

    @Override
    public void update(Object tableEntity) {

    }

    @Override
    public Object findById(Integer id) {

	return null;
    }

    public CityH2DB findByIdCity(Integer id) {

	Query<CityH2DB> query = sessionFactory.openSession().createQuery("from CityH2DB where id= :id", CityH2DB.class);
	query.setParameter("id", id);
	return query.getSingleResult();

    }

    public CountryH2DB findByIdCountry(Long countryId) {
	Query<CountryH2DB> query = sessionFactory.openSession().createQuery("from CountryH2DB where id= :id", CountryH2DB.class);
	query.setParameter("id", countryId);
	return query.getSingleResult();


    }

    public CountryLanguageH2DB findByIdLanguage(long languagesId) {
	Query<CountryLanguageH2DB> query = sessionFactory.openSession().createQuery("from CountryLanguageH2DB where id= :id", CountryLanguageH2DB.class);
	query.setParameter("id", languagesId);
	return query.getSingleResult();
    }
}
