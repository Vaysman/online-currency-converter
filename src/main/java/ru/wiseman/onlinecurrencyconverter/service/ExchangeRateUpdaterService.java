package ru.wiseman.onlinecurrencyconverter.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateUpdaterService {
    @NonNull
    private final ExchangeRateRepository repository;

    @NotNull
    private final RemoteExchangeRateService service;

    public void updateRate() {
    }
}
