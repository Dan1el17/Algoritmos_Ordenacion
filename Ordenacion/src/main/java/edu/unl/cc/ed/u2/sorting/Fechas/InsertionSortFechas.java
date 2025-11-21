package edu.unl.cc.ed.u2.sorting.Fechas;
/**
 * @author Steeven Pardo, Darwin Correa
 * Implementación del algoritmo de ordenación Insercion para arreglos de tipo Long
 * Usado para ordenar citas por fechaHora, usando instrumentacion de metricas
 */
import edu.unl.cc.ed.u2.sorting.Metrics;

import java.io.PrintWriter;
import java.util.Arrays;

public class InsertionSortFechas {

    /**
     * @param arreglo
     * @param traza
     * @param escritor
     * @return
     */
    public static Metrics ordenar(long[] arreglo, boolean traza, PrintWriter escritor) {
        Metrics m = new Metrics();
        long start = System.nanoTime();

        for (int i = 1; i < arreglo.length; i++) {
            long valorActual = arreglo[i];
            int posicion = i - 1;

            while (posicion >= 0 && arreglo[posicion] > valorActual) {
                m.addComparison();
                arreglo[posicion + 1] = arreglo[posicion];
                posicion--;
                m.addSwap();
            }
            if (posicion >= 0) m.addComparison();
            arreglo[posicion + 1] = valorActual;

            if (traza && escritor != null) escritor.println("Iteración " + i + ": " + Arrays.toString(arreglo));
        }

        m.setTime(System.nanoTime() - start);
        if (escritor != null) {
            escritor.println("Total de movimientos: " + m.getSwaps());
            escritor.println("Total de comparaciones: " + m.getComparisons());
            escritor.println("Tiempo(ns): " + m.getTimeNs());
        }
        return m;
    }
}