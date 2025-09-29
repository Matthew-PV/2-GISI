---

# 🖥️ Proyecto: Patrón Builder - Ordenadores

Este proyecto implementa el **Patrón de Diseño Builder** en Java para construir diferentes configuraciones de un objeto `Ordenador` (tipo A, B y C) de manera estructurada y flexible.

---

## 📌 Descripción

El objetivo del proyecto es separar la construcción de un objeto complejo (`Ordenador`) de su representación. De esta forma, con el mismo proceso de construcción podemos crear distintas representaciones (ordenadores con distintas características de RAM, disco duro y pantalla).

Se han creado los siguientes elementos principales:

* **Ordenador**: Clase producto con atributos (`memoria`, `discoDuro`, `pantalla`).
* **OrdenadorBuilder**: Interfaz que define los métodos de construcción.
* **OrdenadorDirector**: Controla el proceso de construcción delegando a un `OrdenadorBuilder`.
* **OrdenadorTipoA, OrdenadorTipoB, OrdenadorTipoC**: Implementaciones concretas del builder.
* **Main**: Clase principal que ejecuta ejemplos de construcción de ordenadores.

---

## 🏗️ Estructura de Clases

* **Ordenador** → Producto final que se construye.
* **OrdenadorBuilder (interface)** → Define los pasos de construcción.
* **OrdenadorTipoA/B/C** → Builders concretos que configuran el ordenador con características distintas.
* **OrdenadorDirector** → Orquesta el proceso de construcción.
* **Main** → Demuestra el uso del patrón.

---

## 📊 Diagrama UML

Aquí se muestra un espacio reservado para el diagrama UML generado con **PlantUML**:

![Diagrama UML.png](Diagrama%20UML.png)

---

## 🚀 Ejecución

Compila y ejecuta el proyecto con los siguientes pasos:

⭐ Compilar todas las clases:

```
javac *.java
```

⭐ Ejecutar la clase principal:

```
java Main
```

---

## 📋 Ejemplo de Salida

⭐

```
Ordenador con 8 GB DDR4 de RAM, 512 GB de HDD de almacenamiento y 20' LED de pantalla.
Ordenador con 16 GB DDR4 de RAM, 1 TB HDD de almacenamiento y 22' LED de pantalla.
Ordenador con 8 GB DDR5 de RAM, 512 GB SSD de almacenamiento y 24' OLED de pantalla.
```

---

## ⚖️ Licencia

Este proyecto está protegido bajo la **Licencia Apache 2.0**.
Consulta el archivo [LICENSE](./LICENSE) para más detalles.

---
