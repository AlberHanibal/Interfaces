# INTERFAZ GRÁFICA DE USUARIO O GUI
- Elemento que funciona como intermediario en la conmunicación entre 2 acores.
- Alan Kay: interfaz gráfica basada en ventanas y escritorio con ratón. Luego lo robó Apple para el Mac en 1984.

## Aspectos a cuidar
-----------------
- Claridad: cada elemento hace lo que se supone que debe hacer.
- Concisa: no sobrecargo de información, ni ruido.
- Familiar: que no cambie los elementos de sitio muchas veces.
- Adaptable (responsive).
- Consistente: usar patrones comunes o familiares.
- Eficiente: conseguir objetivo forma rápida y precisa.
- Generosa: que pueda deshacer errores, ventanas de confirmación.
- Atractiva: que no sea como un orco.

## Color
-----------------
- Combinaciones de colores generan efectos: de confianza, limpieza, excitación.
- Armonías de colores: colores adyacentes, complementarios, complementarios divididos.

## Tipografía
-----------------
Clasificación por forma: 
- la serifa: pequeños remates en extremos, mejora lectura.
- sans-serif: calidad a bajas resoluciones

## Distribución de componentes, interfaz
-----------------
- Claridad: la gente es capaz de reconocer su objetivo
- Conservar atención.
- Acción primaria por pantalla.
- Acciones secundarias en segundo plano.
- Proporcionar paso siguiente natural.
- Apariencia sigue el comportamiento.
- Divulgación progresiva: información poco a poco.
- Ayudar si necesario.
- Estado cero: primera experiencia crucial.

## Prototipo
O wireframe esbozo o borrador visual sobre como será la estructura de interfaz. Para hacerse una idea rápida

# Patrón de diseño MVC
por Trygve Reenskaug en Smalltalk-76 durante su visita a Xerox Park en los años 70. A finales de los 80 se extendío.
1. Usuario interactúa con interfaz.
2. Controlador gestiona evento.
3. Controlador accede al modelo y actualiza.
4. Controlador delega el despliegue a los objetos de la vista, reflejando los cambios.
5. Interfaz espera nuevas interacciones.

### Modelo
-----------------
Capa que trabaja con los datos, acceso y actualizar estado. ORM.

### Vista
-----------------
Código que produce la visualización de la interfaz. No se accede a los datos.

### Controlador
-----------------
Código que responde a acciones que se solicitan. Enlace entre vistas y modelos.