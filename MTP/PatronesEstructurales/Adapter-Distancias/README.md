# 🚗 Proyecto: Adaptador de Distancias (Patrón Adapter)

Proyecto realizado por Matthew Puente-Villegas Michavila

Este proyecto implementa el **Patrón de Diseño Adapter** para unificar la forma de calcular la distancia máxima recorrida por un conductor en distintos sistemas:
la **Unión Europea (kmh)** y **California (mph)**.

Gracias a este patrón, el programa puede reutilizar una clase existente (`CaliforniaDistance`) escrita con unidades imperiales (millas por hora), adaptándola al sistema métrico sin modificar su código original.

---

## 📘 Descripción General

En el sistema original, ya existía una jerarquía de clases basada en el sistema internacional de unidades (kmh).
El objetivo es **incorporar la clase `CaliforniaDistance`**, que trabaja en **millas por hora (mph)**, sin romper la estructura ni reescribir la lógica base.

Para ello se crea el **adaptador `AdaptadorDistanciaCalifornia`**, que convierte automáticamente las unidades entre ambos sistemas (kmh ↔ mph).

---

## 🧩 Diagrama UML

A continuación se muestra el diagrama UML del proyecto:

![Diagrama UML.png](Diagrama%20UML.png)

---

## 🧠 Estructura de Clases

| Clase / Interfaz                 | Tipo            | Descripción                                                                           |
| -------------------------------- | --------------- | ------------------------------------------------------------------------------------- |
| **AvrgSpeed**                    | Interfaz        | Define la operación para establecer la velocidad media del conductor.                 |
| **Distancia**                    | Clase abstracta | Define el método abstracto `distanciaMaxima()`.                                       |
| **DistanciaEU**                  | Concreta        | Implementa la lógica de cálculo para el sistema europeo (kmh).                        |
| **CaliforniaDistance**           | Concreta        | Implementa la lógica en millas por hora (mph), con límites y cálculos propios.        |
| **AdaptadorDistanciaCalifornia** | Adaptador       | Conecta la interfaz europea con la implementación californiana, convirtiendo unidades. |
| **Main**                         | Cliente         | Ejecuta los ejemplos de uso del patrón Adapter.                                       |

---

## ⚙️ Funcionamiento del Programa

1. **DistanciaEU** calcula la distancia máxima usando velocidad media en **kmh** y un tiempo máximo de jornada de **7.5 horas**.
2. **CaliforniaDistance** usa **mph** y un máximo de **8 horas laborales**.
3. **AdaptadorDistanciaCalifornia** convierte automáticamente entre kmh y mph para mantener la compatibilidad con el resto del sistema.

---

## 🧾 Ejemplo de Ejecución

```
Distancia en EU - - - - - -
Cambiando velocidad media a 85.0 kmh.
Calculando distancia máxima.
La distancia máxima es de 637.5 kilómetos.

Distancia en California - - 
Setting average speed to 52.8166 mph.
Calculating maximum distance.
The maximum distance is of 422.5328 miles.
```

---

## 🧱 Patrón de Diseño Utilizado: **Adapter**

Este patrón permite que dos clases con **interfaces incompatibles** trabajen juntas.
En este caso:

* `DistanciaEU` representa el sistema métrico original.
* `CaliforniaDistance` usa millas por hora (imperial).
* `AdaptadorDistanciaCalifornia` actúa como **puente**, convirtiendo unidades y manteniendo la coherencia con la interfaz `AvrgSpeed`.

**Ventajas del patrón:**

* Reutiliza código existente sin modificarlo.
* Mejora la extensibilidad.
* Facilita la integración de sistemas heterogéneos.
  
---

## 📜 Licencia

Este proyecto está protegido bajo la **licencia Apache 2.0**.
Puedes consultar más detalles en el archivo [LICENSE](https://github.com/Matthew-PV/2-GISI/blob/b9ceaaf0f2e2af420acd5861a1e2dc1e8ebeceb5/LICENSE).