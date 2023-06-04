package com.javarush.repository;


import java.util.List;

public interface RepositoryEntities <T> {

    List<T> getAll();
    void delete (Integer id);

    void save(T tableEntity);

    void update(T tableEntity);

   T findById(Integer id);
}
