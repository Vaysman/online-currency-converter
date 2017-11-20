package ru.wiseman.onlinecurrencyconverter.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest({RemoteExchangeRateService.class, RemoteExchangeRateServiceProperties.class})
@TestPropertySource(properties = "rate.service.url=http://example.com/scripts/XML_daily.asp")
public class RemoteExchangeRateServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private RemoteExchangeRateService service;

    @Test
    public void getRateWhenServerIsUpShouldReturnRate() throws Exception {
        server.expect(requestTo("http://example.com/scripts/XML_daily.asp"))
                .andRespond(withSuccess(getClassPathResource("xml_daily_asp.xml"), MediaType.APPLICATION_XML));
        assertThat(service.getRate()).isEqualTo(0.529643f);
    }

    private ClassPathResource getClassPathResource(String path) {
        return new ClassPathResource(path, getClass());
    }
}
