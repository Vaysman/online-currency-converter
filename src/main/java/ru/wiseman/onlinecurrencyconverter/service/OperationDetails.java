package ru.wiseman.onlinecurrencyconverter.service;

import lombok.Value;

@Value
public class OperationDetails {
    String status;
    Float sum;

    public OperationDetails(String status, Float sum) {
        this.status = status;
        this.sum = truncate(sum);
    }

    private Float truncate(float sum) {
        return (float) (Math.floor(sum * 100.0) / 100.0);
    }
}
