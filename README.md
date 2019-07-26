# Fetcher Exercise

## WARNING DOCUMENTATION IN PROGRESS

## Requirementes

* Java 11
* Gradle 5.5.1
* Docker Engine 18.09
* Docker Compose 1.23

## Run

```bash
$ docker-compose up
```

Adminer -> [http://localhost:8081](http://localhost:8081)

* System -> PostgreSQL	
* Server -> db
* Username -> fetcher	
* Password -> fetcher_password	
* Database -> fetcher_db

```$bach
$ ./gradlew bootRun
```

## Endpoints

### Populate database

Github -> [Populate](http://localhost:8080/github/positions?count=50)

Param `count` => Number of positions to retrieve

### Clients Endpoints

[GreenFuture](http://localhost:8080/greenFuture/positions)

[VonMises](http://localhost:8080/vonMises/positions)

[FreeToChoose](http://localhost:8080/freeToChoose/positions)

## Cleanup

```bash
$ docker-compose down
```
