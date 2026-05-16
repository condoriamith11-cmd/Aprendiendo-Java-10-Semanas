# Sistema de Estudiantes con Collections Framework

## Descripción

Este proyecto desarrolla un sistema de gestión de estudiantes utilizando el Collections Framework de Java. El programa permite registrar, buscar, actualizar y eliminar estudiantes mediante estructuras eficientes como `HashMap`, `TreeSet` y `ArrayList`.

Además, el sistema mantiene un ranking automático por promedio, un historial de operaciones y estadísticas generales, todo mediante un menú interactivo en consola.

---

## Tabla comparativa de las colecciones usadas

| Coleccion                     | Rol en el sistema                     | Por que                         |
|------------------------------|---------------------------------------|---------------------------------|
| HashMap<String, Estudiante>  | Busqueda por carnet en O(1)           | Acceso directo                  |
| TreeSet<Estudiante>          | Ranking automatico por promedio       | Orden siempre                   |
| ArrayList<String>            | Historial de operaciones              | Orden de llegada                |

---

## Cómo compilar el proyecto

Ubicarse dentro de la carpeta del proyecto y ejecutar:

```bash
javac Main.java modelo/*.java servicio/*.java
```
## Como Ejecutar el proyecto
```bash  
java Main

```
## Ejemplo de salida del programa
=== SISTEMA DE ESTUDIANTES ===

1. Agregar estudiante
2. Buscar por carnet
3. Actualizar promedio
4. Eliminar estudiante
5. Ver ranking completo
6. Ver top 5
7. Filtrar por carrera
8. Estadisticas
9. Historial
0. Salir

Opcion : 5

=== Ranking de estudiantes ===

1. [2021006] Pedro Vargas       Sistemas       55.0
2. [2021004] Luis Mamani        Civil          61.0
3. [2021010] Diego Arce         Civil          67.5
4. [2021008] Hugo Espejo        Industrial     70.0
5. [2021001] Ana Torres         Sistemas       75.5
6. [2021005] Rosa Flores        Industrial     79.5
7. [2021007] Silvia Choque      Civil          83.5
8. [2021002] Carlos Quispe      Industrial     88.0
9. [2021003] Maria Condori      Sistemas       92.3
10.[2021009] Patricia Lima      Sistemas       95.0

Opcion : 6

=== Top 5 estudiantes ===

1. [2021009] Patricia Lima      Sistemas       95.0
2. [2021003] Maria Condori      Sistemas       92.3
3. [2021002] Carlos Quispe      Industrial     88.0
4. [2021007] Silvia Choque      Civil          83.5
5. [2021005] Rosa Flores        Industrial     79.5
