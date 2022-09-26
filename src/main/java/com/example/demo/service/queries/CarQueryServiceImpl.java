package com.example.demo.service.queries;

import com.example.demo.persistence.replica.CarReadRepository;
import com.example.demo.persistence.replica.dto.CarIdColorDTO;
import com.example.demo.persistence.replica.dto.CardBrandColorDTO;
import com.example.demo.service.CarQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarQueryServiceImpl implements CarQueryService {

    private final CarReadRepository carReadRepository;

    public CarQueryServiceImpl(CarReadRepository carReadRepository) {
        this.carReadRepository = carReadRepository;
    }

    @Override
    public List<CarIdColorDTO> findAllCarIdColorByBrand(CarsByBrand carsByBrand) {
        return this.carReadRepository.findAllCarIdColorByBrand(carsByBrand.getBrand());
    }

    @Override
    public List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(CarsUnderPrice carsUnderPrice) {
        return this.carReadRepository.findAllCarBrandColorUnderPrice(carsUnderPrice.getReferencePrice());
    }
}
