package com.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CalculatorTest {

    @InjectMocks
    private Calculator calculator;

    @Test
    public void add_returnsTwo_whenOneAndOneIsPassed() throws Exception // one standard for naming tests: functionName_whatItDoes_whenWhatIsPassedIntoIt()
    {
        int expected = 2;
        int actual = calculator.add(1, 1);
        assertThat(actual).isEqualTo(expected);
    }
}