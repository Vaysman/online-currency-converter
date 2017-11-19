package ru.wiseman.onlinecurrencyconverter.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConverterService {
    @NonNull
    private final ExchangeRateRepository repository;

    public OperationDetails r2y(float v) {
        return new OperationDetails("OK", 67.89f);
    }

    public OperationDetails y2r(float v) {
        return new OperationDetails("OK", 555.66f);
    }
}
