# Algoritmos_Ordenacion
# Comparación Empírica de Algoritmos de Ordenación

Este proyecto implementa y compara tres algoritmos clásicos de ordenación —**BubbleSort**, **InsertionSort** y **SelectionSort**— sobre tres tipos distintos de datasets. El objetivo es analizar su comportamiento empírico en términos de **comparaciones**, **intercambios (swaps)** y **tiempo de ejecución**, utilizando datos representativos de contextos reales.

## 📊 Datasets utilizados

- **Pacientes por apellido** (`String[]`): líneas CSV con ID, apellido y prioridad. Se ordenan por apellido.
- **Inventario por stock** (`int[]`): valores numéricos en orden descendente. Representa el peor caso para algunos algoritmos.
- **Citas por fechaHora** (`long[]`): fechas en milisegundos, casi ordenadas, con 5 swaps aleatorios.

## ⚙️ Ejecución

1. Asegúrate de tener Java instalado.
2. Coloca los archivos `.csv` en la carpeta `datasets/`.
3. Ejecuta la clase `SortingDemoGeneral.java` desde tu entorno de desarrollo o consola.
4. Revisa los resultados en:
   - `resultados.txt` → métricas por algoritmo
   - `resultadosTrazas.txt` → trazas detalladas de cada paso

## 🧠 Objetivo académico

Este proyecto busca reforzar la comprensión de:
- La eficiencia empírica de algoritmos de ordenación.
- La importancia del orden inicial de los datos.
- La instrumentación de código para análisis comparativo.
- La documentación clara y reproducible de experimentos computacionales.

## 👨‍💻 Autores
### [Steeven Pardo](https://github.com/Dan1el17)
### [Darwin Correa](https://github.com/Darwin090)
