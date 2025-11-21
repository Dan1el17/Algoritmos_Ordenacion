package edu.unl.cc.ed.u2.sorting.Enteros;

/**
 * @author Steeven Pardo, Darwin Correa
 * Implementación del algoritmo de ordenación Insercion para arreglos enteros
 * Usado para ordenar inventario por stock mediante instrumentacion de metricas
 */
import edu.unl.cc.ed.u2.sorting.Metrics;
import java.io.PrintWriter;
import java.util.Arrays;

public class InsertionSort {

    /**
     * Ordena el arreglo usando Inserción y devuelve métricas.
     *
     * @param arreglo  arreglo a ordenar
     * @param traza    si true, muestra trazas en consola y/o archivo
     * @param escritor archivo de salida opcional (puede ser null)
     * @return objeto Metrics con comparaciones, movimientos y tiempo
     */
    public static Metrics ordenar(int[] arreglo, boolean traza, PrintWriter escritor) {
        Metrics m = new Metrics();
        long start = System.nanoTime();

        for (int i = 1; i < arreglo.length; i++) {
            int valorActual = arreglo[i];
            int posicion = i - 1;

            while (posicion >= 0 && arreglo[posicion] > valorActual) {
                m.addComparison();
                arreglo[posicion + 1] = arreglo[posicion];
                posicion--;
                m.addSwap(); // o m.addMove() si renombraste
            }

            if (posicion >= 0) m.addComparison(); // última comparación fallida

            arreglo[posicion + 1] = valorActual;

            if (traza) {
                String paso = "Iteración " + i + ": " + Arrays.toString(arreglo);
                System.out.println(paso);
                if (escritor != null) escritor.println(paso);
            }
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