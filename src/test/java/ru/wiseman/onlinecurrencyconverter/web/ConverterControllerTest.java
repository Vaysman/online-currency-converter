package ru.wiseman.onlinecurrencyconverter.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.wiseman.onlinecurrencyconverter.service.ConverterService;
import ru.wiseman.onlinecurrencyconverter.service.OperationDetails;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConverterController.class)
public class ConverterControllerTest {

    @MockBean
    private ConverterService converterService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void buyWhenRequestSumShouldReturnNumberAndOk() throws Exception {
        given(converterService.r2y(123.45f))
                .willReturn(new OperationDetails("OK", 67.89f));
        mvc.perform(get("/yconverter/buy?sum={sum}", 123.45f).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{sum: 67.89, status: 'OK'}"));
    }

    @Test
    public void sellWhenRequestSumShouldReturnNumberAndOk() throws Exception {
        given(converterService.y2r(333.44f))
                .willReturn(new OperationDetails("OK", 555.66f));
        mvc.perform(get("/yconverter/sell?sum={sum}", 333.44f).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{sum: 555.66, status: 'OK'}"));
    }
}
