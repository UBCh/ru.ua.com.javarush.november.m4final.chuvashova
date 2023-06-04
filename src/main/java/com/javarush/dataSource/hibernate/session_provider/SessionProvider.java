package com.javarush.dataSource.hibernate.session_provider;

import org.hibernate.SessionFactory;

public interface SessionProvider {

    SessionFactory getSessionFactory();

}
