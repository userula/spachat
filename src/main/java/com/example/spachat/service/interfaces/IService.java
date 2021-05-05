package com.example.spachat.service.interfaces;

import java.util.List;

public interface IService<T> {
    void add(T o);
    List<T> getAll();
    void update(T t);
    void delete(T t);
}
