package ru.wiseman.onlinecurrencyconverter.service;

import org.springframework.data.repository.Repository;
import ru.wiseman.onlinecurrencyconverter.domain.ExchangeRate;

public interface ExchangeRateRepository extends Repository<ExchangeRate, Long> {
    ExchangeRate save(ExchangeRate rate);

    ExchangeRate findTopByOrderByTimestampDesc();
}
