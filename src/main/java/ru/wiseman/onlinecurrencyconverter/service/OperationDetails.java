package ru.wiseman.onlinecurrencyconverter.service;

import lombok.Value;

import java.util.Locale;

@Value
public class OperationDetails {
    String status;
    Float sum;

    public OperationDetails(String status, Float sum) {
        this.status = status;
        this.sum = truncate(sum);
    }

    private Float truncate(float sum) {
        // TODO fix this
        String formated = String.format(Locale.US,"%.3f", sum);
        return Float.valueOf(formated.substring(0, formated.length() - 1));
    }
}
