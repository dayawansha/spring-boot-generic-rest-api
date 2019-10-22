# spring Generic Rest API
These APIs have designed to reduce the unnecessary rest API endpoints in your poroject.

when you are working with microservice architecture,
Some times you met small tables. (someone defined as a reference table..etc) 
These tables don't have heavy relationships with other tables.

 However, according to the Spring-Rest-API framework for each entity (Table) you have to write multiple Rest-API endpoints (for CRUD operations).

To skip this problem, This API has been developed.

However, It has some technical limitations.
Basically, you should send the "exact Entity name and their exact field names as key and value pairs". (contained some examples)

To develop this rest-API, java reflection has been  used.

## How to Use (if you know this, please skip),

Just clone.
You should install PostgreSQL in your machine. (otherwise, you have to change application.yml according to the database)

after cloning the project, add the maven dependencies and use the PostgreSQL default database, schema otherwise you have to create a new database and new schema and change the application.yml according to the new credentials. 

You can create the schema, in application.yml,
just change the "hibernate.ddl-auto: create" and run the project. schema will create.
Then change it to "hibernate.ddl-auto: update" and run the project.

## Example:
Our target is Create, read, update and delete (CRUD operations) data to the AGENT table.
It have some foreign keys. first of all, you have to add the foreign key-related data to the tables.

Then we have to add data to CUSTOMER and DEPARTMENT:
Now you can use the same endpoints like theis to add the data for these two tables.

common request body for All  post, put and delete requests, (This java dto will catch rest cliend request data)

```
public class EntityObjectData {
    String className;
    ArrayList<HashMap<String,Object>> entityObjectList;
}
````
Above java DTO will use in rest client like this,
```
{
	"className":"Customer",
	"entityObjectList":
		[
		you can add one or more java entity object with their exact key and valus pairs.
		]

}
```

### POST mapping for data adding.

adding data the CUSTOMER table:
http://localhost:8080/commonEntities
```
{
	"className":"Customer",
	"entityObjectList":
	[
		{
		"name":"customer 1",
    		"address": "address 1"
		},
		{
		"name":"customer 2",
    		"address": "address 2"
		},
		{
		"name":"customer 3",
    		"address": "address 3"
		},
		{
		"name":"customer 4",
    		"address": "address 4"
		},
		{
		"name":"customer 5",
    		"address": "address 5"
		}
		
	]
}
```

Output
```
{
    "message": "Common Object Added Successfully",
    "status": true,
    "statusCode": 200,
    "user": "",
    "timestamp": "2019-10-21T14:26:13.618+0000",
    "id": ""
}
```

adding data the DEPARTMENT table: (post request) http://localhost:8080/commonEntities

```
{
	"className":"Department",
	"entityObjectList":
	[
		{
		"name":"Department 1",
    		"address": "address 1"
		},
		{
		"name":"Department 2",
    		"address": "address 2"
		},
		{
		"name":"Department 3",
    		"address": "address 3"
		}	
	]
}
```
Output
```
{
    "message": "Common Object Added Successfully",
    "status": true,
    "statusCode": 200,
    "user": "",
    "timestamp": "2019-10-21T14:26:13.618+0000",
    "id": ""
}
```

Now you can add data to the AGENT table like this. (post request) http://localhost:8080/commonEntities
```
{
	"className":"Agent",
	"entityObjectList":
	[
		{
			"name":"Agent 1",
			"customer":1,
			"department":1
		},
			{
			"name":"Agent 2",
			"customer":2,
			"department":2
		},
			{
			"name":"Agent 3",
			"customer":3,
			"department":3
		}
		
	]
}
```
Output
```
{
    "message": "Common Object Added Successfully",
    "status": true,
    "statusCode": 200,
    "user": "",
    "timestamp": "2019-10-21T14:26:13.618+0000",
    "id": ""
}
```

### PUT mapping for data update.
(PUT request) http://localhost:8080/commonEntities
```
{
	"className":"Agent",
	"entityObjectList":
	[
		{
			"agentId":1,
			"name":"Agent 11",
			"customer":1,
			"department":1
		},
			{
			"agentId":2,	
			"name":"Agent 22",
			"customer":1,
			"department":1
		},
			{
			"agentId":3,
			"name":"Agent 33",
			"customer":3,
			"department":3
		}
		
	]
}
```
Output
```
{
    "message": "Common Object Updated Successfully",
    "status": true,
    "statusCode": 200,
    "user": "",
    "timestamp": "2019-10-21T16:37:48.292+0000",
    "id": ""
}
```
### GET mapping for data selecting.
(GET request) http://localhost:8080/commonEntities/Agent/1
Agent:- Entity Name
1:- Agnet Id

### DELETE mapping for data deleting.
Import: When you are deleting a record list, Those values should not use from other tables.
If other tables are using records that you are trying to delete, you are unable to delete. (will give a violates foreign key constraint issue)

(DELETE request) http://localhost:8080/commonEntities/Agent/1
Agent:- Entity Name
1:- Agnet Id

```
{
	"className":"Customer",
	"entityObjectList":
	[
		{
			"customerId":4
		
		},
		{
			"customerId":5
		}
		
	]
}
```

Output

```
{
    "message": "Common Object Deleted Successfully",
    "status": true,
    "statusCode": 200,
    "user": "",
    "timestamp": "2019-10-21T17:01:27.163+0000",
    "id": ""
}
```

### Other related methologies,

However, Spring has given some advances features with https://spring.io/projects/spring-data-rest. probably you should read this.
Also this reference will useful. https://github.com/fsonmezay/generic-rest-api









