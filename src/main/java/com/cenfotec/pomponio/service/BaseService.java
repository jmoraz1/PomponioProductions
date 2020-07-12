package com.cenfotec.pomponio.service;

import java.util.List;

public interface BaseService {
    <T> T save(T entity);
    <T> T update (T entity);
    <T> T delete (T entity);
    <T>List<T> getAll();
}
