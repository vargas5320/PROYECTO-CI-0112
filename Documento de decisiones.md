# Documento de decisiones

## Acuerdos de pareja

Para el desarrollo del proyecto, se distribuyeron las tareas de la siguiente manera:

- **Erika** fue responsable del desarrollo completo del juego **Batalla Naval**, incluyendo la lógica del tablero, turnos, disparos y control de vidas.
- **Samuel** se encargó del juego **Ahorcado**, desarrollando el sistema de validación de letras, control de intentos y verificación del ganador.
- **Sebastián** fue el encargado del menú principal en la clase `Juegos.java`, además de encargarse de:
  - La documentación técnica utilizando **Doxygen**.
  - La revisión y **corrección de errores** en los códigos desarrollados por los compañeros.

---

## Decisiones de diseño

- Se crearon clases independientes para cada juego (`Ahorcado`, `BatallaNaval`), cada una con su propia lógica.
- Se diseñaron clases para los jugadores: `Jugador` (para Ahorcado) y `JugadorBN` (para Batalla Naval), ya que manejan atributos distintos.
- La clase `Tablero` tiene el tablero del juego Batalla Naval, con métodos para imprimir, actualizar y verificar el estado del juego.
- El menú principal (`Juegos.java`) funciona el control principal del programa, y se encarga de recibir la entrada del usuario y redirigirla al juego correspondiente.
- Documentación con Doxygen para mantener una estructura más profesional y facilitar la lectura. 

---

## Decisiones de implementación

- Se utilizaron **matrices bidimensionales (`char[][]`, `boolean[][]`)** en el juego Batalla Naval para representar el tablero y la ubicación real de los barcos.
- En el juego Ahorcado, se utilizaron **arreglos de caracteres** y **arreglos auxiliares booleanos** (`palabra1Aux`, etc.) para registrar letras adivinadas.
- El sistema de entrada de datos se diseñó con:
  - Uso de `try-catch` para capturar errores por entradas no válidas (`InputMismatchException`).
  - Uso de (`[A-Z]`) para validar letras mayúsculas en Ahorcado.
- La lógica de turnos se implementó con estructuras simples (`while`, `if`, `boolean`), buscando claridad y facilidad de mantenimiento.
- Se priorizó la legibilidad del código, manteniendo los métodos relativamente cortos y bien nombrados.

---

## Puntos de mejora

- Permitir solo letras no repetidas en Ahorcado, y evitar sobreescribir barcos en Batalla Naval.
- Limpiar la consola entre turnos para mejorar la parte visual.
- Reutilizar clases: se podría crear una superclase `JugadorBase` para compartir código entre `Jugador` y `JugadorBN`.
- Permitir guardar y cargar partidas usando archivos.

---
