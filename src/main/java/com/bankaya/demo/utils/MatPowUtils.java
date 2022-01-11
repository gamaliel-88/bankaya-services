package com.bankaya.demo.utils;

public class MatPowUtils {

    public static Double calcularPow(final double base, final double exponente) {

        final Boolean validarValoresDeEntrada = validarValoresDeEntrada(base, exponente);

        double total = 0;

        if (validarValoresDeEntrada) {

            double limiteJ = base;

            if (!esDecimal(String.valueOf(exponente)) && exponente > 0) {

                int vecesASumarLaBase = ((Double) Double.parseDouble(String.valueOf(exponente))).intValue();

                vecesASumarLaBase -= 1;

                if (vecesASumarLaBase == 0) {
                    vecesASumarLaBase = 1;
                    limiteJ = 1;
                }

                for (int i = 0; i < vecesASumarLaBase; i++) {

                    if (total > 0) {

                        limiteJ = total;
                    }

                    total = 0;

                    for (double j = 0; j < limiteJ; j++) {

                        total = total + base;

                    }

                }

            } else {
                total = 1;
            }

        } else {
            return Double.NaN;
        }

        return total;
    }

    private static Boolean validarValoresDeEntrada(final Double base, final Double exponente) {

        Boolean datosEntradaCorrectos = Boolean.TRUE;

        if (base == null || exponente == null) {

            datosEntradaCorrectos = Boolean.FALSE;

        } else if (base < 0 && esDecimal(exponente.toString())) {

            datosEntradaCorrectos = Boolean.FALSE;
        }

        return datosEntradaCorrectos;

    }

    private static boolean esDecimal(final String cadena) {

        final String[] split = cadena.split("\\.");

        if (split.length > 1) {

            final int valorDecimal = Integer.parseInt(split[1]);

            if (valorDecimal > 0) {
                return true;
            }
        }

        return false;

    }
}
