package edu.unl.cc.ed.u2.sorting.Enteros;
/**
 * @author Steeven Pardo, Darwin Correa
 * Implementación del algoritmo de ordenación Seleccion para arreglos enteros
 * Usado para ordenar inventario por stock mediante instrumentacion de metricas
 */
import edu.unl.cc.ed.u2.sorting.Metrics;
import edu.unl.cc.ed.u2.sorting.SortingUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class SelectionSort {

    /**
     * Ordena el arreglo usando Selección y devuelve métricas.
     *
     * @param arreglo  arreglo a ordenar
     * @param traza    si true, muestra trazas en consola y/o archivo
     * @param escritor archivo de salida opcional
     * @return objeto Metrics con comparaciones, swaps y tiempo
     */
    public static Metrics ordenar(int[] arreglo, boolean traza, PrintWriter escritor) {
        Metrics m = new Metrics();
        long start = System.nanoTime();

        for (int i = 0; i < arreglo.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                m.addComparison();
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                int temporal = arreglo[i];
                arreglo[i] = arreglo[indiceMinimo];
                arreglo[indiceMinimo] = temporal;
                m.addSwap();
            }

            if (traza) {
                System.out.print("Iteración " + i + ": ");
                SortingUtils.imprimirArreglo(arreglo);
                if (escritor != null) {
                    escritor.println("Iteración " + i + ": " + Arrays.toString(arreglo));
                }
            }
        }

        m.setTime(System.nanoTime() - start);

        if (traza && escritor != null) {
            escritor.println("Total de intercambios: " + m.getSwaps());
            escritor.println("Total de comparaciones: " + m.getComparisons());
            escritor.println("Tiempo(ns): " + m.getTimeNs());
        }

        return m;
    }
}