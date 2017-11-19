package ru.wiseman.onlinecurrencyconverter.service;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.wiseman.onlinecurrencyconverter.domain.ExchangeRate;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExchangeRateRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ExchangeRateRepository repository;

    @Test
    public void findTopByOrderByTimestampDescReturnLatestExchangeRate() throws Exception {
        Date now = new Date();
        Date nowPlusOneHour = new DateTime(now).plus(Duration.standardHours(1)).toDate();
        entityManager.persist(new ExchangeRate(1.1f, now));
        entityManager.persist(new ExchangeRate(1.2f, nowPlusOneHour));
        ExchangeRate rate = repository.findTopByOrderByTimestampDesc();
        assertThat(rate.getRate()).isEqualTo(1.2f);
    }

    @Test
    public void saveShouldPersistData() throws Exception {
        repository.save(new ExchangeRate(1.1f, new Date()));
        ExchangeRate rate = repository.findTopByOrderByTimestampDesc();
        assertThat(rate.getRate()).isEqualTo(1.1f);
    }
}
