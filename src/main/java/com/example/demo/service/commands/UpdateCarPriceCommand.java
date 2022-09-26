package com.example.demo.service.commands;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateCarPriceCommand {
    private Long id;
    private BigDecimal price;
}
