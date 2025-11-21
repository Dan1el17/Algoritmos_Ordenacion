package edu.unl.cc.ed.u2.sorting.Fechas;
/**
 * @author Steeven Pardo, Darwin Correa
 * Implementación del algoritmo de ordenación Seleccion para arreglos de tipo Long
 * Usado para ordenar citas por fechaHora, usando instrumentacion de metricas
 */
import edu.unl.cc.ed.u2.sorting.Metrics;

import java.io.PrintWriter;
import java.util.Arrays;

public class SelectionSortFechas {
    /**
     * @param arreglo
     * @param traza
     * @param escritor
     * @return
     */
    public static Metrics ordenar(long[] arreglo, boolean traza, PrintWriter escritor) {
        Metrics m = new Metrics();
        long start = System.nanoTime();

        for (int i = 0; i < arreglo.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                m.addComparison();
                if (arreglo[j] < arreglo[min]) {
                    min = j;
                }
            }
            if (min != i) {
                long temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = temp;
                m.addSwap();
            }
            if (traza && escritor != null) escritor.println("Iteración " + i + ": " + Arrays.toString(arreglo));
        }

        m.setTime(System.nanoTime() - start);
        if (escritor != null) {
            escritor.println("Total de intercambios: " + m.getSwaps());
            escritor.println("Total de comparaciones: " + m.getComparisons());
            escritor.println("Tiempo(ns): " + m.getTimeNs());
        }
        return m;
    }
}
