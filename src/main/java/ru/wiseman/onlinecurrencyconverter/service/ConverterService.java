package ru.wiseman.onlinecurrencyconverter.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    public OperationDetails r2y(float v) {
        return new OperationDetails(null, 0f);
    }

    public OperationDetails y2r(float v) {
        return new OperationDetails(null, 0f);
    }
}
