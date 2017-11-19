package ru.wiseman.onlinecurrencyconverter.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConverterController.class)
public class ConverterControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void buyWhenRequestSumShouldReturnNumberAndOk() throws Exception {
        mvc.perform(get("/yconverter/buy?sum={}", "123.45").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{sum: 67.89, status: 'OK'}"));
    }

    @Test
    public void sellWhenRequestSumShouldReturnNumberAndOk() throws Exception {
        mvc.perform(get("/yconverter/sell?sum={}", "333.44").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{sum: 555.66, status: 'OK'}"));
    }
}
