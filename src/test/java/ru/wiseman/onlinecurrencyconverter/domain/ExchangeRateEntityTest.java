package ru.wiseman.onlinecurrencyconverter.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExchangeRateEntityTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createWhenRateIs0ShouldThrowException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Rate must be greater then 0");
        new ExchangeRate(0f);
    }
}
