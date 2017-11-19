package ru.wiseman.onlinecurrencyconverter.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.wiseman.onlinecurrencyconverter.service.OperationDetails;

@RestController()
@RequestMapping("/yconverter")
public class ConverterController {

    @GetMapping(path = "/buy", produces = MediaType.APPLICATION_JSON_VALUE)
    public OperationDetails buy() {
        return new OperationDetails("OK", 67.89f);
    }
}
