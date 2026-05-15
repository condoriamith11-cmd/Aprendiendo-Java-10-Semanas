# README - Sistema de Gestión de Vehículos

## 1. Descripción del sistema

Este proyecto es un sistema de gestión de vehículos desarrollado en Java usando Programación Orientada a Objetos (POO).  
El programa permite registrar distintos tipos de vehículos, mostrar información, aplicar polimorfismo y trabajar con vehículos eléctricos mediante interfaces.

---

## 2. Diagrama de clases

```text
                [Vehiculo] (abstract)
                       |
         +-------------+-------------+
         |             |             |
       [Auto]       [Moto]       [Camion]
         |             |
 [AutoElectrico]  [MotoElectrica]
         |             |
         +-------------+
               |
      <<Electrico>> (interface)

## 3. Decisiones de diseño

- **Vehiculo** es una clase abstracta porque representa un concepto general de vehículo y no se necesita crear objetos directamente de ella.

- **Electrico** es una interfaz porque diferentes tipos de vehículos pueden ser eléctricos y compartir métodos relacionados con batería y carga.
