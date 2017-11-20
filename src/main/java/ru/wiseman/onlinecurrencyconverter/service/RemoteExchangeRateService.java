package ru.wiseman.onlinecurrencyconverter.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;

@Service
@Slf4j
@RequiredArgsConstructor
public class RemoteExchangeRateService {
    @NonNull
    private final RestTemplate template;

    @NotNull
    private final RemoteExchangeRateServiceProperties properties;

    @Autowired
    public RemoteExchangeRateService(RestTemplateBuilder builder, RemoteExchangeRateServiceProperties properties) {
        this(builder.build(), properties);
    }

    public float getRate() {
        ResponseEntity<String> response = template.getForEntity(properties.getUrl(), String.class);
        log.info("Fetching data from bank");
        Document quotes = Jsoup.parse(response.getBody());
        String rate = quotes.select("Valute[ID=R01820] > Value").text().replace(',', '.');
        log.info("JPY {} rub", rate);
        return Float.valueOf(rate);
    }
}
