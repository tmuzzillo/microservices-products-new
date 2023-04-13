# Products Microservices Project
Microservices to manage products like a Shopping App.
We are going to use Spring framework such as:
Spring Data, Spring Web, Spring Boot, Spring Cloud.

## Modules:

 - **Product Service**: Create and view Products, acts as Product Catalog.
 - **Order Service**: Can order Products.
 - **Inventory Service**: Can check if product is in stock or not.
 - **Notification Service**: Can send notifications after order is palced.
 
 

## Architecture:
Order Service, Inventory Service and Notification Service are going to interact with each other.
With Synchronous and Asynchronous communication.

![arquitectura productos shopping](https://user-images.githubusercontent.com/71854664/225742549-240d7df3-4c8a-4758-8e49-de684446859c.png)


## REST

![rest](https://user-images.githubusercontent.com/71854664/225742578-29bb01df-6445-4c77-b110-fd5eebf76cd1.png)

## Spring Cloud Environment
As we cannot ping to an static IP of the services running because they are running with an dinamic IP in cloud environment, we are going to implement a discovery-server pattern to be able to communicate our services.
To do that we are going to use Netflix Eureka integration.

<img width="768" alt="Discovery service apttern" src="https://user-images.githubusercontent.com/71854664/230744562-132a94fb-eda5-4704-ad02-eef45416dcb4.png">

### Communication in our cloud environment implementing discovery-server pattern
We register our Discovery Service as a "server" and ours other services as "clients". Each client can have a registry of the address of the service that we want to reach in case of the Discovery Service were down.

<img width="454" alt="communication discovery service" src="https://user-images.githubusercontent.com/71854664/230744601-066cb93c-61f3-49e4-b37f-352015fcac6b.png">

![client registry](https://user-images.githubusercontent.com/71854664/230748134-c2e946b4-85c8-41b3-bdaf-96095da10235.png)

## API Gateway
Gateway: Responsable of route the requests from users to the correspond services
![API gateway](https://user-images.githubusercontent.com/71854664/231558700-8e914125-f23c-46e9-8004-664e81bff334.png)

## Security - Keycloak
Gateway securing with keycloak, all services needs a token to receive requests and we need credential to enter to eureka configuration.


