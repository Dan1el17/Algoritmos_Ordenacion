package edu.unl.cc.ed.u2.sorting.Strings;
/**
 * @author Steeven Pardo, Darwin Correa
 * Implementación del algoritmo de ordenación por Seleccion para arreglos de tipo String.
 * Ordena por appeliido ademas incluye intrumentacion de comparaciones swaps y tiempo
 */
import edu.unl.cc.ed.u2.sorting.Metrics;

import java.io.PrintWriter;
import java.util.Arrays;

public class SelectionSortStrings {

    /**
     * @param arreglo
     * @param traza
     * @param escritor
     * @return
     */
    public static Metrics ordenar(String[] arreglo, boolean traza, PrintWriter escritor) {
        Metrics m = new Metrics();
        long start = System.nanoTime();

        for (int i = 0; i < arreglo.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                m.addComparison();
                if (arreglo[j].compareTo(arreglo[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                String temp = arreglo[i];
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