
# Parcial Segundo Corte De AREP

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
Erika Juliana Castro Romero 
