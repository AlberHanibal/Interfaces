# ORGANIZACIÓN
- src: fuentes.
- classes: compilados y jerarquía de subdirectioros o paquetes.
- lib: recursos usados terceros, libreriías o JAR.
- dist: versión final. JAR o formato empaquetado para ejecutar.
- tests: ficheros tests y pruebas unitarias.
- doc: documentación técnica y de nivel usuario. Manuales, información.
- readme y license

## CLASSPATH
- en linux export CLASSPATH=$CLASSPATH:ruta:ruta
- en windows set CLASSPATH=%CLASSPATH%;ruta;ruta
- -cp ruta;ruta 

## JAR
- jar cf cosas.jar *.class
- jar uf cosas.jar clase para añadir una nueva clase al jar
- jar cfm cosas.jar manifiesto.txt clases