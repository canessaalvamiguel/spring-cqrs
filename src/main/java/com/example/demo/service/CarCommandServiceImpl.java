package com.example.demo.service;

import com.example.demo.persistence.master.CarWriterRepository;
import com.example.demo.persistence.model.Car;
import com.example.demo.service.commands.CreateCarCommand;
import com.example.demo.service.commands.UpdateCarPriceCommand;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class CarCommandServiceImpl implements CarCommandService, InitializingBean {

    public CarWriterRepository carWriteRepository;

    public Long idGenerator;

    public CarCommandServiceImpl(CarWriterRepository carWriteRepository) {
        this.carWriteRepository = carWriteRepository;
    }

    @Override
    public void handleCreateCarCommand(CreateCarCommand createCarCommand) {
        Car car = new Car();
        car.setId(++idGenerator);
        car.setColor(createCarCommand.getColor());
        car.setPrice(createCarCommand.getPrice());
        car.setBrand(createCarCommand.getBrand());
        this.carWriteRepository.save(car);
    }
    @Override
    public void handleUpdateCarPriceCommand(UpdateCarPriceCommand updateCarPriceCommand) {
        this.carWriteRepository.findById(updateCarPriceCommand.getId())
                .ifPresent(
                        c -> {
                            c.setPrice(updateCarPriceCommand.getPrice());
                            this.carWriteRepository.update(c);
                        }
                );
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.idGenerator = 0L;
    }
}
