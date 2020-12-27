package com.example.controller;

import com.example.service.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CalculatorController
{
    private final Calculator calculator;

    @GetMapping("/add")
    public int add(@PathVariable int a, @PathVariable int b)
    {
        return calculator.add(a, b);
    }
}