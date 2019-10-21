# spring-generic-rest-repository
spring generic rest repository 

These APIs have designed to reduce the unnecessary rest API endpoints.

when you are working with microservice architecture,
Some times you met small tables. (someone defined as a reference table) 
These tables don't have heavy relationships with other tables.

 However, according to the Spring-Rest-API framework for each entity (Table) you have to write multiple Rest-API endpoints (for CRUD operations).

To skip this problem, This API has been developed.

However, It has some technical limitations.
Basically, you should send the "exact Entity name and their exact field names as key and value pairs". (contained some examples)

To develop this rest-API, java reflection has been  used.

However, Spring has given some advances features with https://spring.io/projects/spring-data-rest. probably you should read this.

Also, This reference will useful. https://github.com/fsonmezay/generic-rest-api

