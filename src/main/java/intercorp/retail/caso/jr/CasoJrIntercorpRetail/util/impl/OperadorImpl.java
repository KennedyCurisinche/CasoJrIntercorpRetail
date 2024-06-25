package intercorp.retail.caso.jr.CasoJrIntercorpRetail.util.impl;

import intercorp.retail.caso.jr.CasoJrIntercorpRetail.util.Operador;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperadorImpl implements Operador {


    @Override
    public BigDecimal promedio(Integer... edades) {

        BigDecimal suma = sumaEdades(edades);

        return suma.divide(BigDecimal.valueOf(edades.length), RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal desviacionEstandar(Integer... edades) {

        BigDecimal promedio = promedio(edades);

        List<BigDecimal> listaEdad = Arrays.stream(edades)
                .map(BigDecimal::new)
                .toList();

        List<BigDecimal> listaResto = new ArrayList<>();

        listaEdad.forEach(e -> listaResto.add(e.subtract(promedio)));

        List<BigDecimal> listaCuadrado = new ArrayList<>();

        listaResto.forEach(r -> listaCuadrado.add(r.pow(2)));

        BigDecimal sumaCuadrado = listaCuadrado.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal divisionSumaCuadrado = sumaCuadrado.divide(BigDecimal.valueOf(edades.length), RoundingMode.HALF_EVEN);

        return divisionSumaCuadrado.sqrt(MathContext.DECIMAL64);
    }

    private BigDecimal sumaEdades(Integer... edades) {

        return Arrays.stream(edades)
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

}
