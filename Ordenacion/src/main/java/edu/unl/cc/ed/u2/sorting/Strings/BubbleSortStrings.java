package edu.unl.cc.ed.u2.sorting.Strings;
/**
 * @author Steeven Pardo, Darwin Correa
 * Implementación del algoritmo de ordenación por burbuja para arreglos de tipo String.
 * Ordena por appeliido ademas incluye intrumentacion de comparaciones swaps y tiempo
 */
import edu.unl.cc.ed.u2.sorting.Metrics;

import java.io.PrintWriter;
import java.util.Arrays;

public class BubbleSortStrings {

    /**
     *
     * @param arreglo
     * @param traza
     * @param escritor
     * @return
     */
    public static Metrics ordenar(String[] arreglo, boolean traza, PrintWriter escritor) {
        Metrics m = new Metrics();
        long start = System.nanoTime();

        boolean huboIntercambio;
        for (int i = 0; i < arreglo.length - 1; i++) {
            huboIntercambio = false;
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                m.addComparison();
                if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
                    String temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    huboIntercambio = true;
                    m.addSwap();
                }
            }
            if (traza && escritor != null) escritor.println("Iteración " + i + ": " + Arrays.toString(arreglo));
            if (!huboIntercambio) break;
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