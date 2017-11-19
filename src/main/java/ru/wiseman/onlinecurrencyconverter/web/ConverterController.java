package ru.wiseman.onlinecurrencyconverter.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.wiseman.onlinecurrencyconverter.service.ConverterService;
import ru.wiseman.onlinecurrencyconverter.service.OperationDetails;

@RestController()
@RequestMapping("/yconverter")
@RequiredArgsConstructor
public class ConverterController {
    @NonNull
    private final ConverterService converterService;

    @GetMapping(path = "/buy", produces = MediaType.APPLICATION_JSON_VALUE)
    public OperationDetails buy(@RequestParam("sum") Float sum) {
        return converterService.r2y(sum);
    }

    @GetMapping(path = "/sell", produces = MediaType.APPLICATION_JSON_VALUE)
    public OperationDetails sell(@RequestParam("sum") Float value) {
        return converterService.y2r(value);
    }
}
