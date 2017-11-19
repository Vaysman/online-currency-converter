package ru.wiseman.onlinecurrencyconverter.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExchangeRateEntityTest {
    private static final Date TIMESTAMP = new Date();

    @Autowired
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createWhenRateIs0ShouldThrowException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Rate must be greater than 0");
        new ExchangeRate(0f, TIMESTAMP);
    }

    @Test
    public void createWhenTimestampIsEmptyShouldThrowException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Timestamp must not be empty");
        new ExchangeRate(1f, null);
    }

    @Test
    public void saveShouldPersistData() throws Exception {
        Date now = new Date();
        ExchangeRate rate = entityManager.persistFlushFind(new ExchangeRate(1.2f, now));
        assertThat(rate.getRate()).isEqualTo(1.2f);
        assertThat(rate.getTimestamp()).usingComparator(Date::compareTo).isEqualTo(now);
    }
}
