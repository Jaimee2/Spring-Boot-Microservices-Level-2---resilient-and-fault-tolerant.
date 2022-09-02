# Spring-Boot-Microservices-Level-2---resilient-and-fault-tolerant.

https://www.youtube.com/watch?v=o8RO38KbWvA&list=PLqq-6Pq4lTTbXZY_elyGv7IkKrfkSrX5e&ab_channel=JavaBrains

Spring Boot Microservices Level 2 - resilient and fault tolerant.


![api externa](https://user-images.githubusercontent.com/52107919/187950397-c35f37fb-841f-4b0f-a723-8027d5ff59a9.png)

## Problemas típicos

### Problema 1: Instancia de un micro-servicio no funciona.

#### Solución: Añadir más instancias de ese micro-servicio

![image](https://user-images.githubusercontent.com/52107919/188092930-875184b7-2163-413a-ba56-cca16a1540bb.png)


### Problema 2: Un micro-servicio funciona lento

![image](https://user-images.githubusercontent.com/52107919/188094019-adfd21b8-0f58-4512-98fd-fdad0215685f.png)

#### Solución: implementar pattern Circuit breaker ---> Framework resilience4j


![image](https://user-images.githubusercontent.com/52107919/188104199-8c5dca76-7b72-4f86-bdba-8a18e4523aa8.png)

EN EL TUTORIAL SE UTLIZA Hystrix QUE ESTÁ EN DESUSO.

## Framework resilience4j

![image](https://user-images.githubusercontent.com/52107919/188126774-f0bae312-35e5-49bb-b87f-bc77d9f663d0.png)

### Configuración

#### application.yml
![image](https://user-images.githubusercontent.com/52107919/188126224-a6edca76-aecb-4ac9-879a-3b2bc2be4cae.png)

#### Implementación:

![image](https://user-images.githubusercontent.com/52107919/188126964-3f31c8e0-8893-4f3b-be89-1106691f5a12.png)

![image](https://user-images.githubusercontent.com/52107919/188127187-2bc4056f-1622-411d-9150-79f509f703db.png)





