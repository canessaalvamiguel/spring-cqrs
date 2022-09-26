package com.example.demo.service;

import com.example.demo.service.commands.CreateCarCommand;
import com.example.demo.service.commands.UpdateCarPriceCommand;

public interface CarCommandService {
    void handleCreateCarCommand(CreateCarCommand createCarCommand);
    void handleUpdateCarPriceCommand(UpdateCarPriceCommand updateCarPriceCommand);
}
