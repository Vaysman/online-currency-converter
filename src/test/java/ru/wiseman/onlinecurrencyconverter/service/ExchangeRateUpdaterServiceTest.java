package ru.wiseman.onlinecurrencyconverter.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.wiseman.onlinecurrencyconverter.domain.ExchangeRate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

public class ExchangeRateUpdaterServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private ExchangeRateRepository repository;

    @Mock
    private RemoteExchangeRateService remoteService;

    @InjectMocks
    private ExchangeRateUpdaterService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void updateRateShouldStoreRateInRepository() throws Exception {
        given(remoteService.getRate()).willReturn(1.23f);

        service.updateRate();

        then(repository).should(times(1)).save(any(ExchangeRate.class));
    }
}
