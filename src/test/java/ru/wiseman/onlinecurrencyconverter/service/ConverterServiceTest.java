package ru.wiseman.onlinecurrencyconverter.service;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterServiceTest {
    private ConverterService converterService;

    @Before
    public void setUp() throws Exception {
        converterService = new ConverterService();
    }

    @Test
    public void y2rWhenDataOkShouldReturnOperationDetails() throws Exception {
        assertThat(converterService.y2r(333.44f)).isEqualTo(new OperationDetails("OK", 555.66f));
    }

    @Test
    public void r2yWhenDataOkShouldReturnOperationDetails() throws Exception {
        assertThat(converterService.r2y(123.45f)).isEqualTo(new OperationDetails("OK", 67.89f));
    }
}
