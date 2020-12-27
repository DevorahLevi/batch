package com.example.controller;

import com.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest
{
    @Mock
    private Calculator mockCalculator;

    @InjectMocks
    private CalculatorController calculatorController;

    @Test
    public void add_shouldCallServiceAndReturnItsResults()
    {
        // There is no real calculator here. Only a mock version of our object. Allows us to test as a UnitTest - test the controller and not what it does.
        // If you would actually try to call the add function on it, it would return null or 0.
        // So our when statement causes it to return 2 when any two numbers, it will always return 2. The when statement will never pass or fail, but
        //      it is setting up our test function. Because we only care about the method signature, not what/how its implementing it.

        // In this test, if our mock calculator calls the add function with any two ints, return 2
        // Not recommended to use just .any(). If you are using an Object that you made, do any(ClassName.class) for it to require that object.
        // When statements MUST go before our mock is invoked.
        when(mockCalculator.add(anyInt(), anyInt())).thenReturn(100);

        // This is our mock call. Must be nestled in between our when statement and our verify statement.
        int actual = calculatorController.add(2, 3);

        // Verify that my mockCalculator's add function was called with 2 and 3
        // eq() is a more specific version of any(). Has to be 2 and has to be 3 as opposed to having it work with any number.
        // ** eq() and any() are both matchers
        // This ensures that our controller merely calls another function rather than just returning a + b and doing actual logic.
        // MUST go after our mock is invoked.
        verify(mockCalculator).add(eq(2), eq(3));

        int expected = 100;

        assertThat(actual).isEqualTo(expected);
    }
}