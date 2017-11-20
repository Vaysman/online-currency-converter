package ru.wiseman.onlinecurrencyconverter.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.wiseman.onlinecurrencyconverter.domain.ExchangeRate;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateUpdaterService {
    @NonNull
    private final ExchangeRateRepository repository;

    @NotNull
    private final RemoteExchangeRateService service;

    public void updateRate() {
        float rate = service.getRate();
        repository.save(new ExchangeRate(rate, new Date()));
    }
}
