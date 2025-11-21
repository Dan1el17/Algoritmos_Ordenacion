package edu.unl.cc.ed.u2.sorting.Dataset;
/**
 * @author Steeven Pardo, Darwin Correa
 * Clase encargada de cargar los datsets desde archivos CSV.
 */
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DatasetLoader {
    /**
     * Cargar apellidos desde pacientes
     * @param ruta
     * @return
     */
    public static String[] cargarApellidos(String ruta) {
        List<String> apellidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 3) {
                    apellidos.add(partes[2].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo pacientes: " + e.getMessage());
        }
        return apellidos.toArray(new String[0]);
    }

    /**
     * Para cargar stock desde inventario
     * @param ruta
     * @return
     */
    public static int[] cargarStock(String ruta) {
        List<Integer> stock = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine(); // Encabezado
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 3) {
                    stock.add(Integer.parseInt(partes[2].trim()));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error leyendo inventario: " + e.getMessage());
        }
        return stock.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Para cargar fechas desde citas (formato ISO 8601)
     * @param ruta
     * @return
     */
    public static long[] cargarFechas(String ruta) {
        List<Long> fechas = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 2) {
                    LocalDateTime fecha = LocalDateTime.parse(partes[2].trim(), formato);
                    fechas.add(fecha.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli());
                }
            }
        } catch (IOException | RuntimeException e) {
            System.out.println("Error leyendo citas: " + e.getMessage());
        }
        return fechas.stream().mapToLong(l -> l).toArray();
    }

}

