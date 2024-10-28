https://github.com/Parcial-1-PDE/Lista-Compra.git

# Lista de la Compra - Aplicación Android

Esta es una aplicación de lista de la compra desarrollada en Android Studio utilizando Java. Permite a los usuarios gestionar su lista de productos, con la posibilidad de introducir el nombre, cantidad y precio aproximado de cada producto.

## Funcionalidades

1. **Agregar Productos**: El usuario puede añadir un producto introduciendo el nombre, cantidad y precio (opcional). El nombre es obligatorio.
   
2. **Eliminar Productos**: Al hacer una pulsación larga sobre un producto en la lista, aparece la opción "Eliminar" que permite al usuario borrar el producto de la lista.

3. **Ver Total de Productos**: La aplicación muestra el número total de productos añadidos a la lista.

4. **Calcular y Ver Precio Total**: La aplicación calcula el precio total de la lista considerando solo los productos que tienen un precio especificado.

## Estructura del Código

La aplicación tiene una estructura simple:

- **MainActivity**: Es la actividad principal que maneja la interfaz de usuario y la lógica de agregar, eliminar productos, y calcular el precio total.
- **Product**: Clase modelo que representa un producto con su nombre, cantidad y precio.

### Recursos

La aplicación está localizada en español e inglés y se adapta automáticamente al idioma del dispositivo.

## Diagrama de Clases

![Diagrama de Clases](diagrama_clases.puml)

## Diagrama de Casos de Uso

![Diagrama de Casos de Uso](diagrama_casos_uso.puml)


## Instalación

1. Clona el repositorio.
2. Abre el proyecto en Android Studio.
3. Ejecuta la aplicación en un emulador o dispositivo físico.

## Uso

1. Abre la aplicación.
2. Escribe el nombre del producto y, opcionalmente, la cantidad y el precio. Luego presiona "Añadir producto" para añadirlo a la lista.
3. Mantén presionado sobre un producto en la lista para ver el menú contextual y selecciona "Eliminar" para borrar el producto.
4. Consulta el número total de productos y el precio total en la parte inferior de la pantalla.


