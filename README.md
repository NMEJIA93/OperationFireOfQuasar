# 🚀 🚀 OperationFireOfQuasar

## 📝 Descripción del Proyecto
Este proyecto aborda un desafío técnico que consta de **dos requerimientos principales**:

1. **Triangulación de un objeto**: Determinar la posición (X, Y) de un emisor desconocido.
2. **Reconstrucción de un mensaje**: Procesar los datos recibidos desde múltiples satélites para reconstruir el mensaje enviado.

Para lograr esto, se cuenta con información de **tres satélites** (cuyos nombres son **kenobi**, **skywalker** y **sato**), los cuales reciben mensajes del emisor. La aplicación procesa estos datos para calcular:

- La posición del emisor.
- El contenido del mensaje enviado.

El desarrollo se divide en **dos etapas**:

### 🔹 Nivel 1: Aplicación de Consola
En esta etapa, la aplicación funciona a través de la consola, interactuando directamente con el usuario. Permite:
- Recibir los datos necesarios (distancias y mensajes de los satélites).
- Procesar los datos.
- Retornar la posición del emisor y el mensaje reconstruido.

### 🔹 Nivel 2: REST API
En la segunda etapa, la funcionalidad se adapta para operar como una **API REST**, proporcionando:
- **Endpoints** para recibir los datos en formato JSON.
- Respuestas estructuradas con la posición calculada y el mensaje reconstruido.

## 💡 Características Principales
- Triangulación  de coordenadas (X, Y) mediante los datos de los satélites.
- Algoritmo de reconstrucción para ensamblar mensajes fragmentados.
- Implementación progresiva con dos modos de interacción:
  - Consola (interacción manual).
  - REST API (interacción automatizada).

## 📚 Tecnologías Utilizadas
- **Lenguaje de programación**: Java (versión 17 o superior).
- **Framework para API**: Spring Boot.
- **Otras herramientas**: Maven para gestión de dependencias.

### 🖥️ Prerrequisitos
Antes de comenzar, asegúrate de tener instalado lo siguiente:
- **Java**: Versión 17 o superior.
- **Git**: Para clonar el repositorio.
- **Maven**: Para construir las dependencias y limpiar el caché.

## 🚀 Instrucciones de Uso

## 🏗️ Arquitectura

Acorde al requerimiento de aplicar la misma lógica para resolver el desafío tanto como aplicación como API REST, se opta por plantear el proyecto bajo la **arquitectura Hexagonal**, dado que esta permite separar responsabilidades y definir claramente la lógica del negocio. Esto facilita la adaptación tanto en forma de API REST como de aplicación.

### 📂 Capas

En este proyecto se manejaron principalmente las capas de **DOMAIN**, **APPLICATION** e **INFRASTRUCTURE**. Esta estructura se basa en la arquitectura elegida y se detalla de la siguiente manera:

---

#### 1️⃣ DOMAIN

Esta capa se subdivide en los paquetes **MODELS**, **REPOSITORIES** y **SERVICES**, lo que ayuda a estructurar el proyecto de forma clara:

- **MODELS**  
  En este paquete se encuentran los modelos requeridos para las entidades definidas en el proyecto:  
  - **Message**  
  - **Point**  
  - **Satellite**  

  Cada uno de estos modelos contiene los atributos necesarios para representar las entidades del negocio.

- **SERVICES**  
  Aquí se encuentra la lógica del negocio, cuyo objetivo es procesar la información y generar los resultados requeridos por el desafío. En este proyecto, estas responsabilidades incluyen:
  - Realizar la triangulación de las coordenadas del emisor del mensaje.
  - Reconstruir el mensaje recibido por cada satélite.

  **Estructura de clases en SERVICES**:
  - `DistanceAdapter`: Prepara los datos necesarios para realizar el proceso de triangulación.  
  - `DistanceCalculator`: Contiene la lógica para realizar la triangulación y retornar las coordenadas del emisor.  
  - `MessageAdapter`: Gestiona las operaciones relacionadas con los modelos del dominio.  
  - `MessageConstructor`: Implementa la lógica para reconstruir el mensaje recibido.

- **REPOSITORIES**  
  Define las interfaces que interactúan con las fuentes de datos necesarias para el proyecto.

---

#### 2️⃣ APPLICATION

En esta capa se encuentra la interfaz encargada de la **persistencia de datos**. Esta interfaz interactúa con el repositorio, que para este proyecto emula una base de datos en memoria.

---

#### 3️⃣ INFRASTRUCTURE

En esta capa se gestionan los adaptadores y controladores, adaptando el proyecto a los dos niveles definidos:

- **Nivel 1: Aplicación de Consola**  
  La interacción con el usuario se realiza mediante consola, gestionando los inputs y outputs directamente desde esta capa.

- **Nivel 2: REST API**  
  La funcionalidad del proyecto se expone como endpoints REST, facilitando la interacción automatizada con otros sistemas.

---

### 📝 Observación

Hasta este punto, el proyecto está planteado para que pueda adaptarse al **Nivel 1 (aplicación)**. En este nivel, definido como una aplicación de consola, se puede interactuar directamente con los datos de entrada y salida.  
En el **Nivel 2 (API REST)**, el manejo se adapta para exponer los servicios mediante controladores y adaptadores REST.

## 📝 Descripción del Proyecto
Este proyecto aborda un desafío técnico que consta de **dos requerimientos principales**:

1. **Triangulación de un objeto**: Determinar la posición (X, Y) de un emisor desconocido.
2. **Reconstrucción de un mensaje**: Procesar los datos recibidos desde múltiples satélites para reconstruir el mensaje enviado.

Para lograr esto, se cuenta con información de **tres satélites** (cuyos nombres son **kenobi**, **skywalker** y **sato**), los cuales reciben mensajes del emisor. La aplicación procesa estos datos para calcular:

- La posición del emisor.
- El contenido del mensaje enviado.

El desarrollo se divide en **dos etapas**:

### 🔹 Nivel 1: Aplicación de Consola
En esta etapa, la aplicación funciona a través de la consola, interactuando directamente con el usuario. Permite:
- Recibir los datos necesarios (distancias y mensajes de los satélites).
- Procesar los datos.
- Retornar la posición del emisor y el mensaje reconstruido.

### 🔹 Nivel 2: REST API
En la segunda etapa, la funcionalidad se adapta para operar como una **API REST**, proporcionando:
- **Endpoints** para recibir los datos en formato JSON.
- Respuestas estructuradas con la posición calculada y el mensaje reconstruido.

## 💡 Características Principales
- Triangulación  de coordenadas (X, Y) mediante los datos de los satélites.
- Algoritmo de reconstrucción para ensamblar mensajes fragmentados.
- Implementación progresiva con dos modos de interacción:
  - Consola (interacción manual).
  - REST API (interacción automatizada).

## 📚 Tecnologías Utilizadas
- **Lenguaje de programación**: Java (versión 17 o superior).
- **Framework para API**: Spring Boot.
- **Otras herramientas**: Maven para gestión de dependencias.

### 🖥️ Prerrequisitos
Antes de comenzar, asegúrate de tener instalado lo siguiente:
- **Java**: Versión 17 o superior.
- **Git**: Para clonar el repositorio.
- **Maven**: Para construir las dependencias y limpiar el caché.

## 🚀 Instrucciones de Uso

## 🏗️ Arquitectura

Acorde al requerimiento de aplicar la misma lógica para resolver el desafío tanto como aplicación como API REST, se opta por plantear el proyecto bajo la **arquitectura Hexagonal**, dado que esta permite separar responsabilidades y definir claramente la lógica del negocio. Esto facilita la adaptación tanto en forma de API REST como de aplicación.

### 📂 Capas

En este proyecto se manejaron principalmente las capas de **DOMAIN**, **APPLICATION** e **INFRASTRUCTURE**. Esta estructura se basa en la arquitectura elegida y se detalla de la siguiente manera:

---

#### 1️⃣ DOMAIN

Esta capa se subdivide en los paquetes **MODELS**, **REPOSITORIES** y **SERVICES**, lo que ayuda a estructurar el proyecto de forma clara:

- **MODELS**  
  En este paquete se encuentran los modelos requeridos para las entidades definidas en el proyecto:  
  - **Message**  
  - **Point**  
  - **Satellite**  

  Cada uno de estos modelos contiene los atributos necesarios para representar las entidades del negocio.

- **SERVICES**  
  Aquí se encuentra la lógica del negocio, cuyo objetivo es procesar la información y generar los resultados requeridos por el desafío. En este proyecto, estas responsabilidades incluyen:
  - Realizar la triangulación de las coordenadas del emisor del mensaje.
  - Reconstruir el mensaje recibido por cada satélite.

  **Estructura de clases en SERVICES**:
  - `DistanceAdapter`: Prepara los datos necesarios para realizar el proceso de triangulación.  
  - `DistanceCalculator`: Contiene la lógica para realizar la triangulación y retornar las coordenadas del emisor.  
  - `MessageAdapter`: Gestiona las operaciones relacionadas con los modelos del dominio.  
  - `MessageConstructor`: Implementa la lógica para reconstruir el mensaje recibido.

- **REPOSITORIES**  
  Define las interfaces que interactúan con las fuentes de datos necesarias para el proyecto.

---

#### 2️⃣ APPLICATION

En esta capa se encuentra la interfaz encargada de la **persistencia de datos**. Esta interfaz interactúa con el repositorio, que para este proyecto emula una base de datos en memoria.

---

#### 3️⃣ INFRASTRUCTURE

En esta capa se gestionan los adaptadores y controladores, adaptando el proyecto a los dos niveles definidos:

- **Nivel 1: Aplicación de Consola**  
  La interacción con el usuario se realiza mediante consola, gestionando los inputs y outputs directamente desde esta capa.

- **Nivel 2: REST API**  
  La funcionalidad del proyecto se expone como endpoints REST, facilitando la interacción automatizada con otros sistemas.

---

### 📝 Observación

Hasta este punto, el proyecto está planteado para que pueda adaptarse al **Nivel 1 (aplicación)**. En este nivel, definido como una aplicación de consola, se puede interactuar directamente con los datos de entrada y salida.  
En el **Nivel 2 (API REST)**, el manejo se adapta para exponer los servicios mediante controladores y adaptadores REST.



## 📋 Ejemplos JSON Requests

### `POST /topsecret/`
**Request JSON**:
```json
{
  "satellites": [
    {
      "name": "kenobi",
      "distance": 100.0,
      "message": ["this", "", "", "message", ""]
    },
    {
      "name": "skywalker",
      "distance": 115.5,
      "message": ["", "is", "", "", "secret"]
    },
    {
      "name": "sato",
      "distance": 142.7,
      "message": ["this", "", "a", "", ""]
    }
  ]
}

POST /topsecret_split/{satellite_name}
Descripción: Actualiza la posición de un satélite específico.

Request JSON:

{
  "x": 100.0,
  "y": 200.0
}

PATCH /topsecret_split/{satellite_name}
Descripción: Actualiza la posición de un satélite específico.
si bien en el desafio se indica que sea solicitud POST tambien se tiene habilitado con solicitud PATCH dado que esta es la que usualmente se usa para actualizaciones parciales


{
  "x": 150.0,
  "y": 250.0
}

 

POST /topsecret_splitMessage/{satellite_name}

Descripción: Actualiza el mensaje recibido por un satélite específico.
la URL de es distinta a la indicada en el desafio dado que ya se tenia una solicitud POST con la ruta /topsecret_split/{satellite_name}

{
  "distance": 120.0,
  "message": ["este", "es", "un", "mensaje", "de", "prueba"]
}