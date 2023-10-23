# Funcionalidad

## Clase nota
-----------
- Leer directorio para sacar listadoNotas
- Modificar nota

## Controlador
---------------
Nota es el que se comunica con los datos, el controlador usa los métodos de Nota y le llama desde la vista
- Filtrado de notas
    - Cada vez que escribas un caracter se vaya refrescando
- Crear nota
    - Comprobar bien formada
        - Sino alerta error
    - Añadirla al listado
- Modificar nota
    - Comprobar bien formada
        - Sino alerta error
    - Cambiarla del listado si cambió el título
- Borrar nota
    - Alerta de confirmación
    - Quitarla del listado

## Interfaz
-------------
### Menú
- Componente propio
- Que resalte para que se sepa que es menú
### Col izq
- Filtrado
    - Como almacenar los títulos de las notas con su nombre de fichero
    - Detectar teclado y filtrar
- Listado
    - onClick para mostrar nota
    - hover, cambio de ratón para saber que es clickable
### Contenido
- TextArea
- Boton crear, guardar, borrar, cancelar, no sé donde

--------------
#### Cosas a mirar
- Cuando se de a borrar se ponga la app modo borrado y en el listado a la derecha un icono de borrar, que se siga pudiendo ver notas
- Cuando se de a modificar se ponga la app modo modificar, igual de lo de arriba
- Si hay css poder seleccionar varios borrados a la vez haciendo unos bordes




