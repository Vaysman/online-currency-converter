package ru.wiseman.onlinecurrencyconverter.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    public OperationDetails r2y(float v) {
        return new OperationDetails("OK", 67.89f);
    }

    public OperationDetails y2r(float v) {
        return new OperationDetails("OK", 555.66f);
    }
}
