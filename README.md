
# Parcial Segundo Corte De AREP

En este parcial, el objetivo es diseñar, construir y desplegar una aplicación web para investigar los factores de números enteros y los números primos. La aplicación se desplegará en tres máquinas virtuales de EC2 de AWS, utilizando maven, git, github, sparkjava como tecnologías. 

El problema consiste en crear un prototipo de sistema de microservicios que tenga un servicio para computar las funciones numéricas. El servicio de las funciones numéricas debe estar desplegado en al menos dos instancias virtuales de EC2. Además, debe implementar un service proxy que reciba las solicitudes de llamado desde los clientes y se las delega a las dos instancias del servicio numérico usando un algoritmo de round-robin. El proxy deberá estar desplegado en otra máquina EC2.
# Herramientas 
- [MAVEN](https://maven.apache.org) : Para el manejo de las dependecias.
  <p align="center">
  <IMG src=https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Apache_Maven_logo.svg/1280px-Apache_Maven_logo.svg.png height=150 width=250 >
    <p/>
- [GIT](https://git-scm.com) : Para el manejo de las versiones.
  <p align="center">
  <IMG src=https://logowik.com/content/uploads/images/git6963.jpg height=150 width=250 >
    <p/>
- [JAVA](https://www.java.com/es/) : Lenguaje de programación manejado.
  <p align="center">
  <IMG src=https://1000marcas.net/wp-content/uploads/2020/11/Java-logo.png height=150 width=250> 
  <p/>
- [AWS Academy](https://awsacademy.instructure.com/) : Para el uso de una máquina virtual.
  <p align="center">
  <IMG src=https://software.uniandes.edu.co/wp-content/uploads/2022/04/1500px_Academy_logo_HD.png height=150 width=250> 
  <p/>
# Arquitectura 
Es un servidor web simple que utiliza el framework Spark para Java. El servidor tiene tres puntos de conexión: uno para saludar con un mensaje "Hello Docker!", otro para calcular los factores de un número entero dado, y otro para calcular los números primos menores que un número entero dado.

El servidor utiliza el método get del framework Spark para definir las rutas y los manejadores para cada punto de conexión. El método get toma dos parámetros: una ruta y un manejador que se ejecuta cuando se recibe una solicitud en esa ruta.

El punto de conexión "hello" simplemente devuelve un mensaje de texto.

El punto de conexión "factors" recibe un número entero como parámetro en la solicitud y devuelve una lista de los factores de ese número en formato JSON.

El punto de conexión "primes" recibe un número entero como parámetro en la solicitud y devuelve una lista de los números primos menores que ese número en formato JSON.

El servidor también utiliza el método port para especificar el puerto en el que se ejecutará. Por defecto, se utiliza el puerto 4567, pero se puede cambiar a través de una variable de entorno llamada "PORT".

* Los factores de un número son todos los números que dividen exactamente a ese número, sin dejar resto. Además del número mismo, 1 es un factor de todos los números. Para encontrar los factores de un número n, la función Factores solo necesita mirar los números hasta n/2, ya que cualquier número mayor que n/2 no será un factor de n.
    **Por ejemplo, si la función recibe 18 como entrada, la lista de factores será [1, 2, 3, 6, 9, 18].**
* Un número primo es un número entero mayor a 1 que solo es divisible por 1 y por sí mismo. Es decir, un número primo no tiene ningún divisor entero distinto de 1 y de sí mismo. El número 1 no se considera un número primo.Para encontrar los números primos menores o iguales a n, la función Primos itera sobre los números desde 2 hasta n y verifica si cada número es primo. Si un número es primo, se agrega a la lista de resultados.
  **Por ejemplo, si la función recibe 10 como entrada, la lista de números primos será [2, 3, 5, 7].**
# Correr el proyecto de manera local 

+ Primero clonar el repositorio con el siguiente comando:
  ~~~
  git clone https://github.com/Juc28/AREP_Parcial2.git
  ~~~
+ Entrar a la carperta del proyecto con el siguiente comando:
  ~~~
  cd AREP_Parcial2
  ~~~
  ![image](https://github.com/Juc28/AREP_Parcial2/assets/118181224/04c8eb6c-e2a7-42f6-ac67-4ab038e1cd81)

+ Compilar con el siguiente comando:
  ~~~
  mvn clean install
  ~~~
  ![image](https://github.com/Juc28/AREP_Parcial2/assets/118181224/760ce87a-a5e1-4da0-8279-726d28a56cfb)

+ Correr con el siguiente comando:
  ~~~
  java -cp "target/classes;target/dependency/*" org.example.SparkWebServer
  ~~~
  ![image](https://github.com/Juc28/AREP_Parcial2/assets/118181224/47bead6e-6b5e-49d6-8a4b-c8b07469c8f9)

+ Abrir en el navegador de la siguiente forma:
  + Para probar los factores:
    ~~~
    http://localhost:4567/factors?valor=15
    ~~~
    ![image](https://github.com/Juc28/AREP_Parcial2/assets/118181224/8f4999aa-8a8d-4b05-8cf9-29f14b4af1b3)
  + Para probar los primos:
  + ~~~
    http://localhost:4567/primes?valor=100
    ~~~
    ![image](https://github.com/Juc28/AREP_Parcial2/assets/118181224/c2f721a4-e876-429d-bd8d-be75de5cd044)

# Correr el proyecto en AWS 
* instancias:
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/de21bb0d-8f93-4c4d-b49d-32450c07f212)
* Las vamos a correr desde la página de aws para esto se elige la instacia a conectarse:
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/8ca2ea35-627f-4b32-84cb-bae7c0e0870b)
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/5279f2c9-c341-4f12-8871-88437aae364d)
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/d71b198d-8673-4d9a-904c-0385c4bb5efc)


* Vamos a instalar java,maven y git para poder correr el proyecto:
   ```
   sudo yum install java 
    ```
   ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/846ad4bb-2e6d-487b-a31b-983ec3b0cf41)

   ```
   sudo yum install maven 
   ```
   ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/236f9a29-d5e7-4a19-b280-da8d28418628)

    ```
  sudo yum install git
    ```
    ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/d5f8de73-da3b-472e-b867-16efa5e274b0)

* Ahora clonar el repositorio con el siguiente comando:
  ~~~
  git clone https://github.com/Juc28/AREP_Parcial2.git
  ~~~
* Entrar a la carperta del proyecto con el siguiente comando:
  ~~~
  cd AREP_Parcial2
  ~~~
   ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/f9f28e60-f21c-46de-8128-2518ef5c504c)


+ Compilar con el siguiente comando:
  ~~~
  mvn clean install
  ~~~
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/3fe639bd-cfda-4d69-a76c-56ecb664e14a)


+ Correr con el siguiente comando:
  ~~~
  java -cp "target/classes:target/dependency/*" org.example.SparkWebServer
  ~~~
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/6bbb21d9-2eef-491a-8df0-0a269a426dd4)
# Prueba con la primera instacia
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/d16acb0a-d703-45fe-b7c8-d567d5207fd5)

* En el path del nagedaor colocamos lo siguiente:
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/2d92e560-e836-4e99-a6c7-960c8f041637)
  ~~~
  http://ec2-54-227-67-200.compute-1.amazonaws.com:4567/primes?valor=100
  ~~~
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/4ae9d551-5318-4080-bb09-193655d8a334)
  ~~~
   http://ec2-54-227-67-200.compute-1.amazonaws.com:4567/factors?valor=15
  ~~~
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/22554d3f-e0d0-457f-ad8d-222688e497ea)
# Prueba con la segunda instacia 
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/a6b05f3e-b541-4ebc-916b-f43c4b81140d)

* En el path del nagedaor colocamos lo siguiente:
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/76e6016d-e87c-445a-a90d-18a0a1dd2448)

  ~~~
  http://ec2-34-204-92-15.compute-1.amazonaws.com:4567/primes?valor=120
  ~~~
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/f4883a7f-1268-4c11-bd4c-4242e971ee0f)

  ~~~
  http://ec2-34-204-92-15.compute-1.amazonaws.com:4567/factors?valor=20
  ~~~
  ![imagen](https://github.com/Juc28/AREP_Parcial2/assets/118181224/4b1c00dd-bd79-4e73-8b9a-68fd3568abeb)
# Prueba del Despliegue: 

[VIDEO DESPLIEGUE AWS](https://youtu.be/ZxcrNNYQL1U)

# Autor 
Erika Juliana Castro Romero [Juc28](https://github.com/Juc28)
