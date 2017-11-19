package ru.wiseman.onlinecurrencyconverter.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.wiseman.onlinecurrencyconverter.domain.ExchangeRate;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class ConverterServiceTest {
    private static final Date ANY_DATE = new Date();

    @Mock
    private ExchangeRateRepository repository;

    @InjectMocks
    private ConverterService converterService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void y2rWhenValueGraterOrEqualZeroReturnOperationDetails() throws Exception {
        given(repository.findTopByOrderByTimestampDesc()).willReturn(new ExchangeRate(0.5296f, ANY_DATE));
        assertThat(converterService.y2r(333.44f)).isEqualTo(new OperationDetails("OK", 176.59f));
    }

    @Test
    public void r2yWhenValueGraterOrEqualZeroReturnOperationDetails() throws Exception {
        given(repository.findTopByOrderByTimestampDesc()).willReturn(new ExchangeRate(0.5296f, ANY_DATE));
        assertThat(converterService.r2y(123.45f)).isEqualTo(new OperationDetails("OK", 233.1f));
    }
}
