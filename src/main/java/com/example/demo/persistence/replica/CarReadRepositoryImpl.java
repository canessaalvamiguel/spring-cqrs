package com.example.demo.persistence.replica;

import com.example.demo.persistence.database.InMemoryDB;
import com.example.demo.persistence.model.Car;
import com.example.demo.persistence.replica.dto.CarIdColorDTO;
import com.example.demo.persistence.replica.dto.CardBrandColorDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarReadRepositoryImpl implements CarReadRepository{

    // Simulates a connexion to a "replica" db, only reading access
    private InMemoryDB<Long, Car> replicaDb;

    public CarReadRepositoryImpl(InMemoryDB<Long, Car> replicaDb) {
        this.replicaDb = replicaDb;
    }

    @Override
    public List<CarIdColorDTO> findAllCarIdColorByBrand(String brand) {
        return this.replicaDb.getStore()
                .entrySet()
                .stream()
                .map(m -> m.getValue())
                .filter(c -> brand.equals(c.getBrand()))
                .map(m -> new CarIdColorDTO(m.getId(), m.getColor()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(BigDecimal referencePrice) {
        return this.replicaDb.getStore()
                .entrySet()
                .stream()
                .map(m->m.getValue())
                .filter(c-> referencePrice.compareTo(c.getPrice()) < 0)
                .map(m -> new CardBrandColorDTO(m.getBrand(), m.getColor()))
                .collect(Collectors.toList());
    }
}
