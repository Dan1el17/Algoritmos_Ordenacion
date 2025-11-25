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

## Resultados 
TABLA: Pacientes por apellido

<img width="577" height="98" alt="image" src="https://github.com/user-attachments/assets/6de90ac5-ec05-4779-820d-3f22aa089564" />

TABLA: Inventario por Stock

<img width="577" height="112" alt="image" src="https://github.com/user-attachments/assets/daa5503b-dc5c-4110-9d76-fe0254d0f037" />

TABLA: Pacientes por apellido citas_100_casi_ordenadas.csv

<img width="578" height="100" alt="image" src="https://github.com/user-attachments/assets/aa91f0e2-15f8-4bc9-b3d8-a0036d3c26b2" />

TABLA: Cita por fecha hora citas_100.csv

<img width="583" height="103" alt="image" src="https://github.com/user-attachments/assets/3748e8db-7466-4391-8034-1083d2ec87e1" />

Graficos 

<img width="868" height="468" alt="image" src="https://github.com/user-attachments/assets/9ed30c11-b26d-4ce9-b405-dcdbf6c38a39" />

<img width="657" height="414" alt="image" src="https://github.com/user-attachments/assets/6a12d17d-1ebf-4b6f-adf3-6fa5ec56e8cc" />

### Matriz de recomendación

<img width="575" height="512" alt="image" src="https://github.com/user-attachments/assets/4063bc57-ca5e-4679-b862-da7076ca33a1" />

## Conclusiones

- Inserción es el ganador claro en datos casi ordenados y con duplicados.
- Selección es el más robusto cuando no conocemos el grado de orden.
- Burbuja con corte temprano solo es competitivo en casi ordenado.

## Manual de Usuario

## Descargar el  proyecto en .zip 

Paso 1: Instalar y usar  el JDK 23.

Paso 2: Coloque los archivos CSV llamados pacientes_500.csv, inventario_500_inverso.csv y citas_100_casi_ordenadas.csv dentro de una carpeta llamada “data”.

Paso 3: Compile el proyecto para generar los archivos necesarios.

Paso 4: Ejecute el programa principal llamado edu.unl.cc.ed.u2.sorting.SortingDemoGeneral.

Paso 5: El programa procesará automáticamente los datos, aplicará los algoritmos de ordenación y generará los archivos resultados.txt y resultadosTrazas.txt.

  
## Autores
### [Steeven Pardo](https://github.com/Dan1el17)
### [Darwin Correa](https://github.com/Darwin090)
