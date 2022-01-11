package com.bankaya.demo.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@SuppressWarnings("deprecation")
public class MatPowUtilsTest {

    @Test
    public void calcularConSieteyCero() {

        final Double base = new Double(7);
        final Double exponente = new Double(0);

        final Double calcularPow = MatPowUtils.calcularPow(base, exponente);

        final double pow = Math.pow(base, exponente);

        assertEquals(calcularPow, pow);

    }

    @Test
    public void calcularConSieteyUno() {

        final Double base = new Double(7);
        final Double exponente = new Double(1);

        final Double calcularPow = MatPowUtils.calcularPow(base, exponente);

        final double pow = Math.pow(base, exponente);

        assertEquals(calcularPow, pow);

    }

    @Test
    public void calcularConSieteyTres() {

        final Double base = new Double(7);
        final Double exponente = new Double(3);

        final Double calcularPow = MatPowUtils.calcularPow(base, exponente);

        final double pow = Math.pow(base, exponente);

        assertEquals(calcularPow, pow);

    }
}
