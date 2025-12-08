# 📘 Gestión de Empleados con SQLite (Java)

Este proyecto es un ejemplo completo de cómo conectarse a una base de datos SQLite utilizando JDBC, cómo crear tablas, insertar datos mediante *prepared statements*, consultar registros, actualizarlos y cerrar correctamente los recursos.

Incluye buenas prácticas, mensajes coloreados en consola, y una estructura modular para facilitar la comprensión del acceso a bases de datos en Java.

---

## 🛠️ Estructura del programa

El programa sigue el siguiente diagrama UML:
![Diagrama UML.png](Diagrama%20UML.png)

## 📂 Funcionalidades principales

El programa realiza los siguientes pasos:

### **1️⃣ Conexión a la base de datos**

Se conecta (o crea automáticamente) la base de datos `practica.db` mediante el driver:

```text
org.sqlite.JDBC
```

---

### **2️⃣ Creación de la tabla `empleado`**

La tabla contiene los siguientes campos:

| Campo           | Tipo        | Descripción                    |
| --------------- | ----------- | ------------------------------ |
| `id`            | INTEGER PK  | Identificador autoincrementado |
| `nombre`        | VARCHAR(50) | Nombre del empleado            |
| `telefono`      | VARCHAR(20) | Teléfono de contacto           |
| `salario`       | DOUBLE      | Salario del empleado           |
| `fechaContrato` | DATE        | Fecha de contratación          |

---

### **3️⃣ Inserción de registros mediante prepared statements**

Se insertan tres empleados iniciales:

* Pepe
* Juan
* Marcos

Además, existe un método para insertar empleados mediante consola:

```java
insertarEmpleadoConsola(connection);
```

---

### **4️⃣ Listado de empleados**

Se ejecuta una consulta SQL y se muestran todos los registros:

```
ID, NOMBRE, TELÉFONO, SALARIO, FECHACONTRATO
--------------------------------------------
```

---

### **5️⃣ Actualización de un registro**

Se incrementa el salario de **Marcos** un 20%:

```sql
UPDATE empleado
SET salario = salario * 1.2
WHERE nombre = 'Marcos'
```

El nuevo salario se consulta y se muestra por pantalla.

---

### **6️⃣ Cierre correcto de conexiones**

El programa cierra:

* `ResultSet`
* `PreparedStatement`
* `Connection`

Todo ello con manejo de excepciones y mensajes coloreados.

---

## 🧩 Métodos auxiliares del programa

El código define varias funciones que encapsulan comportamiento repetitivo:

### ✔️ `ejecutarActualizacion(Connection, String)`

Ejecuta sentencias SQL como `INSERT`, `UPDATE`, `DELETE`, `DROP TABLE`, etc.

### ✔️ `ejecutarConsulta(Connection, String)`

Ejecuta consultas SQL (`SELECT`) y devuelve un `ResultSet`.

### ✔️ `insertarEmpleado(Connection, ...)`

Facilita la inserción segura de nuevos empleados usando parámetros.

### ✔️ `insertarEmpleadoConsola(Connection)`

Permite insertar un empleado solicitando los datos por teclado.

---

## ▶️ Ejecución del programa

El programa se ejecuta desde el `main`, donde se llama paso a paso a todas las operaciones:

* Conexión
* Creación de tabla
* Inserciones
* Listado
* Actualización
* Cierre

### Resultado de ejecución
![MPM - Salida por Consola - Práctica BBDD de MTP.png](MPM%20-%20Salida%20por%20Consola%20-%20Pr%C3%A1ctica%20BBDD%20de%20MTP.png)

---

## 📦 Requisitos

### **Dependencia JDBC de SQLite**

Debes incluir el driver de SQLite, por ejemplo:

```
org.xerial:sqlite-jdbc
```

---

## 🗄 Estructura generada en la base de datos

Ejemplo de datos tras la ejecución:

| ID | Nombre | Teléfono  | Salario    | FechaContrato |
| -- | ------ | --------- | ---------- | ------------- |
| 1  | Pepe   | 600100100 | 1200.0     | 2025-06-12    |
| 2  | Juan   | 610010010 | 1350.0     | 2025-08-22    |
| 3  | Marcos | 642511271 | **1320.0** | 2024-02-11    |

*(Marcos recibe un aumento del 20%.)*

---