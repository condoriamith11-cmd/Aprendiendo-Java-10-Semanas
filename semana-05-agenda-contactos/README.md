
# Agenda de Contactos con JSON

## 1. Descripción del sistema

Este proyecto consiste en una agenda de contactos desarrollada en Java utilizando Maven y la librería Gson. El sistema permite agregar, buscar, editar, eliminar y listar contactos, manteniendo la información almacenada en archivos JSON incluso después de cerrar el programa.

Además, el proyecto implementa excepciones personalizadas, validaciones de datos y generación automática de backups para evitar pérdida de información.

---

## 2. Explicación del formato JSON

El programa utiliza archivos JSON para almacenar los contactos en la carpeta:
data/contactos.json
Cada contacto se guarda como un objeto JSON con atributos como ID, nombre, teléfono y email.
El uso de JSON permite que los datos sean fáciles de leer, modificar y recuperar mediante la librería Gson.

---

## 3. Tabla de excepciones personalizadas

| Excepción | Tipo | Cuándo se lanza |
|------------|------------|------------------------------|
| ContactoNoEncontradoException | Checked | Cuando no existe un contacto con el ID o nombre buscado |
| ContactoExistenteException | Checked | Cuando se intenta registrar un contacto ya existente |
| DatoInvalidoException | Unchecked | Cuando un dato ingresado no cumple las validaciones |

---

## 4. Cómo instalar y ejecutar con Maven

### Descargar dependencias y compilar

```bash
mvn compile
```

### Compilar y Ejecutar (si la clase se llama Main)

```bash
mvn exec:java -Dexec.mainClass="Main"
```
## Capturas del programa

### Ejemplo de salida 1

![Ejemplo 1](capturas/Ejemplo%20de%20Salida-05-0.png)

### Ejemplo de salida 2

![Ejemplo 2](capturas/Ejemplo%20de%20Salida-05-1.png)

### Ejemplo de salida 3

![Ejemplo 3](capturas/Ejemplo%20de%20Salida-05-2.png)

### Ejemplo de salida 4

![Ejemplo 4](capturas/Ejemplo%20de%20Salida-05-3.png)

### Persistencia de datos

![Persistencia](capturas/Ejemplo%20Salida(persistencia%20de%20datos)-05-4.png)
