package com.javarush.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class H2DBRepository implements RepositoryEntities{
   private String path1="src/main/resources/create.sql";
   private String path2="src/main/resources/data.sql";

//    CountryH2DB countryH2DB;
//    CityH2DB cityH2DB;
//    CountryLanguageH2DB countryLanguageH2DB;


    static SessionFactory sessionFactory;

    public H2DBRepository(SessionFactory sessionFactory) throws IOException {
	this.sessionFactory = sessionFactory;
//	createBD();
	runSqlScriptFile(path1);
	runSqlScriptFile(path2);
    }




//
//
//    private  void createBD(){
//   prepareData();
//    try (Session session = sessionFactory.openSession()) {
//    session.beginTransaction();
//
//    session.persist(cityH2DB);
//
//	session.persist(countryH2DB);
//	session.persist(countryLanguageH2DB);
//      session.getTransaction().commit();}}
//
//
//
//private void prepareData(){
//
//    countryH2DB = new CountryH2DB(1,"Australia","Oceania", 120000,5,1);
//     cityH2DB=new CityH2DB(5,"Camberra",1,"Camberra",1000000);
//    countryLanguageH2DB=new CountryLanguageH2DB(1,"England");
//
//}
//
//
//    public  void shouBD(){
//
//	try (Session session = sessionFactory.openSession()) {
//	    session.beginTransaction();
//	    CityH2DB getted_entity = session.get(CityH2DB.class, 5);
//	    System.out.println(getted_entity);
//	    session.getTransaction().commit();}
//    }
//




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
}
