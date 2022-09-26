package com.example.demo.service;

import com.example.demo.persistence.replica.dto.CarIdColorDTO;
import com.example.demo.persistence.replica.dto.CardBrandColorDTO;
import com.example.demo.service.queries.CarsByBrand;
import com.example.demo.service.queries.CarsUnderPrice;

import java.util.List;

public interface CarQueryService {
    List<CarIdColorDTO> findAllCarIdColorByBrand(CarsByBrand carsByBrand);
    List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(CarsUnderPrice carsUnderPrice);
}
