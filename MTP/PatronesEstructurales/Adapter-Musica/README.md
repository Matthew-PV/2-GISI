# 🎵 Proyecto: Adaptadores de Plataformas Musicales (Spotify y Apple Music)

Proyecto realizado por Matthew Puente-Villegas

Este proyecto demuestra el uso del **Patrón Adaptador (Adapter Pattern)** para integrar distintas plataformas de música —en este caso, **Spotify** y **Apple Music**— bajo una misma interfaz unificada.

El objetivo es permitir que ambas plataformas compartan una estructura común de comandos (reproducir, parar, cambiar canción, mostrar información, etc.), sin modificar el código interno de cada una.

---

## 🧩 Estructura del Proyecto

```
📁 PlataformasMusica
 ┣ 📁 AppleMusic
 ┃ ┣ 📄 AdaptadorAppleMusic.java
 ┃ ┣ 📄 AppleMusic.java
 ┃ ┗ 📄 AppleMusicInterface.java
 ┣ 📁 Spotify
 ┃ ┣ 📄 AdaptadorSpotify.java
 ┃ ┣ 📄 Spotify.java
 ┃ ┗ 📄 SpotifyInterface.java
 ┗ 📄 AdaptadorPlataformas.java
📄 Main.java
```

---

## 🧠 Descripción de las Clases

### 🎧 `AdaptadorPlataformas`

Interfaz general que define los métodos comunes que deben implementar todas las plataformas de música:

* `parar()`
* `reproducir()`
* `infoCancion()`
* `cambiarCancion(String cancion)`

### 🎵 `AdaptadorSpotify`

Actúa como adaptador entre el programa principal y la clase `Spotify`.
Convierte las llamadas genéricas en acciones específicas del entorno Spotify.

### 🍎 `AdaptadorAppleMusic`

Cumple la misma función, pero adaptando las llamadas al entorno Apple Music.
Internamente, utiliza un objeto `AppleMusic` para manejar las acciones reales.

### 💿 `Spotify` y `AppleMusic`

Clases concretas que representan las implementaciones originales de cada plataforma, con sus propias lógicas de reproducción.

### 🧩 Interfaces específicas

Cada plataforma cuenta con su propia interfaz:

* `SpotifyInterface`
* `AppleMusicInterface`

Estas definen el comportamiento esperado dentro de cada entorno.

---

## 🧱 Estructura de Clases y Relaciones

![Diagrama UML.png](Diagrama%20UML.png)

---

## 🚀 Ejemplo de Ejecución

```
Reproducir en Spotify:
Cambiando a canción Beautiful Things - Benson Boone en Spotify.
Reproduciendo canción en Spotify.
Estás escuchando la canción Beautiful Things - Benson Boone en Spotify.

Reproducir en Apple Music:
Changing song to More Than Words - SHAUN on Apple Music.
Playing song on Apple Music.
You're listening to More Than Words - SHAUN on Apple Music.
```

---

## ⚙️ Cómo Funciona

1. **`Main.java`** crea instancias de ambos adaptadores (`AdaptadorSpotify` y `AdaptadorAppleMusic`).
2. El usuario puede interactuar con ambos a través de la interfaz común `AdaptadorPlataformas`.
3. Cada adaptador traduce las acciones genéricas en comandos propios de su sistema.
4. Esto permite unificar el control sin modificar las clases originales de Spotify ni Apple Music.

---

## 🧩 Patrón de Diseño Aplicado: Adapter

El **Patrón Adaptador** permite que clases con interfaces incompatibles trabajen juntas.
En este caso, tanto `Spotify` como `AppleMusic` poseen métodos con nombres y comportamientos distintos.
Gracias a sus adaptadores (`AdaptadorSpotify` y `AdaptadorAppleMusic`), ambas pueden interactuar de forma homogénea con el programa principal.

---

## ⚖️ Licencia

Este proyecto está protegido bajo la **Licencia Apache 2.0**.
Consulta el archivo [LICENSE](https://github.com/Matthew-PV/2-GISI/blob/b9ceaaf0f2e2af420acd5861a1e2dc1e8ebeceb5/LICENSE) para más información sobre derechos y limitaciones.