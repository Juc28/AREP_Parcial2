
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
Se tiene dos funciones que son:
* Factores --> Esta retonar un json con las lista de lo números correspondientes.
  + 1 es un factor de todos los números
  + de ahí en adelante simplemente mirando el módulo puede verificar si es o no factor.
  + Puede mirar todos los numeros hasta n/2
  + n pertenece también a los factores.
* Primos --> Esta retonar un json con las lista de lo números primos menores o iguales a n.
  + 1 no es un número primo
  + de ahí en adelante recuerde que un número es primo si solo es divisible por 1 y por si mismo.
  + Es decir un número es primo si el tamaño del conjunto de factores es 2.
    
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

# Autor 
Erika Juliana Castro Romero [Juc28](https://github.com/Juc28)
