package edu.unl.cc.ed.u2.sorting;
/**
 * @author Steeven Pardo, Darwin Correa
 * Con esta clase buscamos evitar repetir codigo dentro de las clases principales
 */

import java.util.Arrays;

public final class SortingUtils {

    /**
     * Mediante este metodo vamos a poder imprimir el arreglo en una sola linea
     * @param arreglo
     */
    public static void imprimirArreglo(int[] arreglo) {
        for (int numero : arreglo) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }

    /**
     * Este arreglo nos permitira tener una copia del arreglo original
     * @param original
     * @return
     */
    public static int[] clonarArreglo(int[] original) {
        return Arrays.copyOf(original, original.length);
    }

    /**
     * Vamos a comparar si dos arreglos son iguales
     * @param a
     * @param b
     * @return
     */
    public static boolean sonIguales(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }
}