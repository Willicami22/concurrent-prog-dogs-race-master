## Escuela Colombiana de Ingeniería

## Arquitecturas de Software – ARSW

# Taller – programación concurrente, condiciones de carrera y sincronización de hilos.

## Integrantes 

- Manuel David Robayo Vega
- William Camilo Hernandez Deaza

### Parte I
Creación, puesta en marcha y coordinación de hilos.

1. Revise el programa “primos concurrentes”. Este es un programa que calcula los números primos entre dos intervalos, distribuyendo la búsqueda de los mismos entre hilos independientes. Por ahora, tiene un único hilo de ejecución que busca los primos entre 0 y 30.000.000. Ejecútelo, abra el administrador de procesos del sistema operativo, y verifique cuantos núcleos son usados por el mismo.  
- Al ejecutar el programa como indica el enunciado y monitorear el rendimiento por medio del panel de control para verificar los núcles usados en memoria, encontramos que el equipo utiliza todos los núcleos disponibles durante la ejecución.  
![1ThreadCores](/img/media/img1.png)  

2. Modifique el programa para que, en lugar de resolver el problema con un solo hilo, lo haga con tres, donde cada uno de éstos hará la tarcera parte del problema original. Verifique nuevamente el funcionamiento, y nuevamente revise el uso de los núcleos del equipo.
- Al dividir el problema en 3 hilos y monitorear el rendimiento de los núcleos en memoria, no notamos un cambio significativo pues se siguen usando todos los núcles del sistema.  
![3ThreadsCores](/img/media/img2.png)  

3. Lo que se le ha pedido es: debe modificar la aplicación de manera que cuando hayan transcurrido 5 segundos desde que se inició la ejecución, se detengan todos los hilos y se muestre el número de primos encontrados hasta el momento. Luego, se debe esperar a que el usuario presione ENTER para reanudar la ejecución de los mismo.
- Justo después de iniciar los hilos, el proceso principal se mantiene en espera durante 5 segundos. Al reanudarse, pausa la ejecución de los demás hilos modificando el valor de una bandera, de manera que, antes de entrar en el método run(), cada hilo verifique si debe continuar o quedar en espera. Posteriormente, cuando el usuario presiona ENTER, la bandera cambia nuevamente de valor y se notifica a los hilos para que prosigan con su ejecución hasta finalizar.
  Al completar la segunda parte de este laboratorio, concluimos que resultaba redundante que cada hilo notificara a todos los demás. Notamos que una mejor opción es implementar una clase controladora, encargada de centralizar la lógica para pausar y reanudar los hilos de forma más sencilla y eficiente.  
  ![5secondsWait](/img/media/img3.png)  







