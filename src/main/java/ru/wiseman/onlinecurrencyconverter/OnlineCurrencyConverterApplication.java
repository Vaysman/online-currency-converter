package ru.wiseman.onlinecurrencyconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnlineCurrencyConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineCurrencyConverterApplication.class, args);
    }
}
