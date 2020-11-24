# Adidas Coding Challenge

This is a project based on two different services that communicate through a Rest API. CitiesServer accesses a Postgres database and offers information for citiesClient, which is in charge of calculating the shortest routes, both in terms of time and connections, between some Spanish cities. For this porpuse, A* algorithm is used, estimating heuristic values with the city's coordinates and Pythagorean trigonometry.

## Build & Run

Due to there are 2 services, you have to build the JAR files separately before creating their own Docker images.

```
## Jars and images build

cd citiesServer
./mvnw clean package 
docker build -t citiesserver .

cd ../citiesClient
./mvnw clean package
docker build -t citiesclient .


## Run!
cd ..
docker-compose up -d
```

## Access
I include some postman examples of how to interact with both citiesServer and citiesClient api through Postman in "postman_collection.json", which you can import directly.

### Postgres
```
http://localhost:5436/

username: springuser
password: springuser
```

### CitiesServer
```
http://localhost:9090/
```

### CitiesClient
```
http://localhost:9091/
```

### Swagger
CitiesServer:
```
http://localhost:9090/swagger-ui/
```

CitiesClient:
```
http://localhost:9091/swagger-ui/
```

## Libs

### Spring Boot Dependencies
It's third part library from Spring suite tools to manager spring dependencies.

### Postgres
It's a free and open-source relational database management system.

### Swagger
It's an open source tools to deliver APIs.

### Virtual Studio Code
It's a code editor redefined and optimized for building and debugging modern web and cloud applications.

### Postman
It's an API development tool which helps to build, test and modify APIs.