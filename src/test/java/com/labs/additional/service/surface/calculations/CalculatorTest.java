package com.labs.additional.service.surface.calculations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        Map<String, Double> coefficients = Map.of(
                "a11", 3d, "a22", 0d, "a33", 0d,
                "a44" ,-1d, "a13",-2d, "a24", 2.5, "a12", 0d,
                "a23", 0d, "a34", 0d, "a14", 0d);
        calculator.setCoefficients(coefficients);
    }

    @Test
    void roundInt() {
        double expected = 1.;
        double actual = Calculator.round2(1.);
        assertEquals(expected, actual);
    }

    @Test
    void round4decimal() {
        double expected = 1.23;
        double actual = Calculator.round2(1.2342);
        assertEquals(expected, actual);
    }

    @Test
    void round6decimal() {
        double expected = 1.23;
        double actual = Calculator.round2(1.227682);
        assertEquals(expected, actual);
    }

    @Test
    void testCalcValues() {
        Map<String, Double> expected = Map.of(
                "I1", 3d, "I2", -4d, "I3", 0d, "I4", 25d,
                "K2", -9.25, "K3", -14.75,
                "lambda1", -1d, "lambda2", 4d, "lambda3", 0d);

        assertEquals(expected, calculator.calcValues());
    }
}