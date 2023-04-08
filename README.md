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
<img width="454" alt="communication discovery service" src="https://user-images.githubusercontent.com/71854664/230744601-066cb93c-61f3-49e4-b37f-352015fcac6b.png">

