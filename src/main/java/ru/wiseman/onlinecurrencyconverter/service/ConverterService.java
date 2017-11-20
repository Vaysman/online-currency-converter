package ru.wiseman.onlinecurrencyconverter.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.wiseman.onlinecurrencyconverter.domain.ExchangeRate;

@Service
@RequiredArgsConstructor
public class ConverterService {
    @NonNull
    private final ExchangeRateRepository repository;

    public OperationDetails r2y(float v) {
        ExchangeRate rate = repository.findTopByOrderByTimestampDesc();
        return new OperationDetails("OK", v / rate.getRate());
    }

    public OperationDetails y2r(float v) {
        ExchangeRate rate = repository.findTopByOrderByTimestampDesc();
        return new OperationDetails("OK", v * rate.getRate());
    }
}
