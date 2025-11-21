package edu.unl.cc.ed.u2.sorting;
/**
 * @author Steeven Pardo, Darwin Correa
 * Se encarga de ejecutar la comparacion de los algortimos de ordenacion
 * ademas genera metricas de rendimiento y trazas paso a paso
 */
import edu.unl.cc.ed.u2.sorting.Dataset.DatasetLoader;
import edu.unl.cc.ed.u2.sorting.Enteros.BubbleSort;
import edu.unl.cc.ed.u2.sorting.Enteros.InsertionSort;
import edu.unl.cc.ed.u2.sorting.Enteros.SelectionSort;
import edu.unl.cc.ed.u2.sorting.Fechas.BubbleSortFechas;
import edu.unl.cc.ed.u2.sorting.Fechas.InsertionSortFechas;
import edu.unl.cc.ed.u2.sorting.Fechas.SelectionSortFechas;
import edu.unl.cc.ed.u2.sorting.Strings.BubbleSortStrings;
import edu.unl.cc.ed.u2.sorting.Strings.InsertionSortStrings;
import edu.unl.cc.ed.u2.sorting.Strings.SelectionSortStrings;

import java.io.*;
import java.util.*;

public class SortingDemoGeneral {

    public static void main(String[] args) {
        try (
                PrintWriter salida = new PrintWriter("resultados.txt");
                PrintWriter trazas = new PrintWriter("resultadosTrazas.txt")
        ) {
            salida.println("---BIENVENIDO---");
            salida.println("---TALLER 6: Comparación de Ordenación con Datasets---");

            String[] pacientes = DatasetLoader.cargarApellidos("pacientes_500.csv");
            ejecutarYRegistrar("Pacientes por apellido", pacientes, salida, trazas);

            int[] stock = DatasetLoader.cargarStock("inventario_500_inverso.csv");
            ejecutarYRegistrar("Inventario por stock", stock, salida, trazas);

            long[] fechas = DatasetLoader.cargarFechas("citas_100_casi_ordenadas.csv");
            ejecutarYRegistrar("Citas por fechaHora", fechas, salida, trazas);

            System.out.println("Los resultados se guardaron en 'resultados.txt' y trazas en 'resultadosTrazas.txt'");

        } catch (IOException e) {
            System.out.println("Error al guardar los archivos: " + e.getMessage());
        }
    }

    /**
     * Sobrecarga para String
     * @param nombre
     * @param datos
     * @param salida
     * @param trazas
     */
    public static void ejecutarYRegistrar(String nombre, String[] datos, PrintWriter salida, PrintWriter trazas) {
        salida.println("\n=== " + nombre + " ===");
        salida.println("Original: " + Arrays.toString(datos));

        String[] copia1 = Arrays.copyOf(datos, datos.length);
        String[] copia2 = Arrays.copyOf(datos, datos.length);
        String[] copia3 = Arrays.copyOf(datos, datos.length);

        Metrics m1 = BubbleSortStrings.ordenar(copia1, false, null);
        Metrics m2 = InsertionSortStrings.ordenar(copia2, false, null);
        Metrics m3 = SelectionSortStrings.ordenar(copia3, false, null);

        salida.println("BubbleSort -> " + m1);
        salida.println("InsertionSort -> " + m2);
        salida.println("SelectionSort -> " + m3);

        trazas.println("\n→ Trazas de BubbleSort sobre " + nombre);
        BubbleSortStrings.ordenar(Arrays.copyOf(datos, datos.length), true, trazas);
    }

    /**
     * Sobrecarga para int
     * @param nombre
     * @param datos
     * @param salida
     * @param trazas
     */
    public static void ejecutarYRegistrar(String nombre, int[] datos, PrintWriter salida, PrintWriter trazas) {
        salida.println("\n=== " + nombre + " ===");
        salida.println("Original: " + Arrays.toString(datos));

        int[] copia1 = Arrays.copyOf(datos, datos.length);
        int[] copia2 = Arrays.copyOf(datos, datos.length);
        int[] copia3 = Arrays.copyOf(datos, datos.length);

        Metrics m1 = BubbleSort.ordenar(copia1, false, null);
        Metrics m2 = InsertionSort.ordenar(copia2, false, null);
        Metrics m3 = SelectionSort.ordenar(copia3, false, null);

        salida.println("BubbleSort -> " + m1);
        salida.println("InsertionSort -> " + m2);
        salida.println("SelectionSort -> " + m3);

        trazas.println("\n→ Trazas de BubbleSort sobre " + nombre);
        BubbleSort.ordenar(Arrays.copyOf(datos, datos.length), true, trazas);
    }

    /**
     * Sobrecarga para las fechas
     * @param nombre
     * @param datos
     * @param salida
     * @param trazas
     */
    public static void ejecutarYRegistrar(String nombre, long[] datos, PrintWriter salida, PrintWriter trazas) {
        salida.println("\n=== " + nombre + " ===");
        salida.println("Original: " + Arrays.toString(datos));

        long[] copia1 = Arrays.copyOf(datos, datos.length);
        long[] copia2 = Arrays.copyOf(datos, datos.length);
        long[] copia3 = Arrays.copyOf(datos, datos.length);

        Metrics m1 = BubbleSortFechas.ordenar(copia1, false, null);
        Metrics m2 = InsertionSortFechas.ordenar(copia2, false, null);
        Metrics m3 = SelectionSortFechas.ordenar(copia3, false, null);

        salida.println("BubbleSort -> " + m1);
        salida.println("InsertionSort -> " + m2);
        salida.println("SelectionSort -> " + m3);

        trazas.println("\n→ Trazas de BubbleSort sobre " + nombre);
        BubbleSortFechas.ordenar(Arrays.copyOf(datos, datos.length), true, trazas);
    }
}