package com.javarush.repository;




public interface RepositoryEntities <T> {


    void delete (T tableEntity);

    void save(T tableEntity);

    void update(T tableEntity);

   T findById(long id);
}
