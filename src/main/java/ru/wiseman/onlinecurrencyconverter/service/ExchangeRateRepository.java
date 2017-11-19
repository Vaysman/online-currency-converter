package ru.wiseman.onlinecurrencyconverter.service;

import org.springframework.data.repository.Repository;
import ru.wiseman.onlinecurrencyconverter.domain.ExchangeRate;

import java.util.List;

public interface ExchangeRateRepository extends Repository<ExchangeRate, Long> {
    ExchangeRate save(ExchangeRate rate);
    ExchangeRate findTopByOrderByTimestampDesc();
}
