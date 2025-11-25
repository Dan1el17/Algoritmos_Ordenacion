<img width="575" height="512" alt="image" src="https://github.com/user-attachments/assets/4afb1240-4a20-4eb0-a4db-4217813e4c7f" /># Algoritmos_Ordenacion
# Comparación Empírica de Algoritmos de Ordenación

Este proyecto implementa y compara tres algoritmos clásicos de ordenación —**BubbleSort**, **InsertionSort** y **SelectionSort**— sobre tres tipos distintos de datasets. El objetivo es analizar su comportamiento empírico en términos de **comparaciones**, **intercambios (swaps)** y **tiempo de ejecución**, utilizando datos representativos de contextos reales.

## Datasets utilizados
- **Pacientes por apellido** (`String[]`): líneas CSV con ID, apellido y prioridad. Se ordenan por apellido.
- **Inventario por stock** (`int[]`): valores numéricos en orden descendente. Representa el peor caso para algunos algoritmos.
- **Citas por fechaHora** (`long[]`): fechas en milisegundos, casi ordenadas, con 5 swaps aleatorios.

## Datasets generados (semilla 42)
- citas_100.csv → 100 citas aleatorias
- citas_100_casi_ordenadas.csv → 5 swaps exactos sobre el ordenado
- pacientes_500.csv → muchos duplicados en apellido/prioridad
- inventario_500_inverso.csv → orden estrictamente inverso por stock


## 2. Código fuente
- `DatasetGenerator.java` → genera los 4 CSV (ejecutar una sola vez)
- `SortingBenchmark.java` → algoritmos instrumentados + contadores
- `Main.java` → carga CSV, ejecuta R=10 corridas, descarta 3, toma mediana

## 3. Resultados obtenidos
### Tablas comparativas
(pegar aquí la tabla grande que te di)

### Matriz de recomendación
<img width="575" height="512" alt="image" src="https://github.com/user-attachments/assets/4063bc57-ca5e-4679-b862-da7076ca33a1" />





## 5. Conclusiones
- Inserción es el ganador claro en datos casi ordenados y con duplicados.
- Selección es el más robusto cuando no conocemos el grado de orden.
- Burbuja con corte temprano solo es competitivo en casi ordenado.






## Autores
### [Steeven Pardo](https://github.com/Dan1el17)
### [Darwin Correa](https://github.com/Darwin090)
