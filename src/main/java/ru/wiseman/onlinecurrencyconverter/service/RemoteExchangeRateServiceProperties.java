package ru.wiseman.onlinecurrencyconverter.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "rate.service")
public class RemoteExchangeRateServiceProperties {
    private String url;
}
