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

#### Solución: implementar pattern Circuit breaker ---> Framework Hystrix


![image](https://user-images.githubusercontent.com/52107919/188104199-8c5dca76-7b72-4f86-bdba-8a18e4523aa8.png)



## Framework Hystrix

![image](https://user-images.githubusercontent.com/52107919/188109604-ef720161-15c2-4745-b861-50bed5b152c1.png)

Hystrix implementa el patron Circuit breaker siguiendos los pasos:

![image](https://user-images.githubusercontent.com/52107919/188109253-9ebfcee7-e8a7-4486-a8c2-935ba74e0fb2.png)




