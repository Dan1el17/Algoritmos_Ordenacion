package edu.unl.cc.ed.u2.sorting.Enteros;
/**
 * @author Steeven Pardo, Darwin Correa
 * Implementación del algoritmo de ordenación Burbuja para arreglos enteros
 * Usado para ordenar inventario por stock mediante instrumentacion de metricas
 */

import edu.unl.cc.ed.u2.sorting.Metrics;
import java.io.PrintWriter;
import java.util.Arrays;

public class BubbleSort {

    /**
     * Ordena el arreglo usando Burbuja con corte temprano y devuelve métricas.
     *
     * @param arreglo  arreglo a ordenar
     * @param traza    si true, muestra trazas en consola y/o archivo
     * @param escritor archivo de salida opcional (puede ser null)
     * @return objeto Metrics con comparaciones, swaps y tiempo
     */
    public static Metrics ordenar(int[] arreglo, boolean traza, PrintWriter escritor) {
        Metrics m = new Metrics();
        long start = System.nanoTime();

        boolean huboIntercambio;
        for (int i = 0; i < arreglo.length - 1; i++) {
            huboIntercambio = false;
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                m.addComparison();
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    huboIntercambio = true;
                    m.addSwap();
                }
            }

            if (traza) {
                String paso = "Iteración " + i + ": " + Arrays.toString(arreglo);
                System.out.println(paso);
                if (escritor != null) escritor.println(paso);
            }

            if (!huboIntercambio) {
                if (traza) {
                    String corte = "→ Corte en la iteración " + i;
                    System.out.println(corte);
                    if (escritor != null) escritor.println(corte);
                }
                break;
            }
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