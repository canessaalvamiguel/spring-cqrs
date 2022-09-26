package com.example.demo.persistence.master;

import com.example.demo.persistence.database.InMemoryDB;
import com.example.demo.persistence.model.Car;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CarWriteRepositoryImpl implements CarWriterRepository{

    //Simulated a real db, only writer responsibilities
    public InMemoryDB<Long, Car> masterDb;

    public CarWriteRepositoryImpl(InMemoryDB<Long, Car> masterDb) {
        this.masterDb = masterDb;
    }

    @Override
    public void save(Car car) {
        this.masterDb.getStore().put(car.getId(), car);
    }

    @Override
    public void update(Car car) {
        this.save(car);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(this.masterDb.getStore().get(id));
    }
}
