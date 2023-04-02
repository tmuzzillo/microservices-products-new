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
