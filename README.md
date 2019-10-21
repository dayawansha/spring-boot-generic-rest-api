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

How to Use,

Just clone. (if you know this, please skip)
You should install PostgreSQL in your machine. (otherwise, you have to change application.yml according to the database)

after cloning the project, add the maven dependencies and use the PostgreSQL default database, schema otherwise you have to create a new database and new schema and change the application.yml according to the new credentials. 

You can create the schema, in application.yml,
just change the "hibernate.ddl-auto: create" and run the project. schema will create.
Then change it to "hibernate.ddl-auto: update" and run the project.


Exmaple:
we are going to add data to the AGENT table.




