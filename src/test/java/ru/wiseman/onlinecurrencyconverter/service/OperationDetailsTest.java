package ru.wiseman.onlinecurrencyconverter.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationDetailsTest {
    @Test
    public void getSumShouldReturnTruncateSum() throws Exception {
        OperationDetails details = new OperationDetails("OK", 1.119111f);
        assertThat(details.getSum()).isEqualTo(1.11f);
    }

    @Test
    public void getSumShouldReturnUnchangedSum() throws Exception {
        OperationDetails details = new OperationDetails("OK", 1.98f);
        assertThat(details.getSum()).isEqualTo(1.98f);
    }
}
