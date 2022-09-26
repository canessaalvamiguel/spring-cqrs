package com.example.demo.persistence.master;

import com.example.demo.persistence.model.Car;

import java.util.Optional;

public interface CarWriterRepository {
    void save(Car car);
    void update(Car car);
    Optional<Car> findById(Long id);
}
