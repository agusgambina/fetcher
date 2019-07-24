# Fetcher Exercise

## WARNING DOCUMENTATION IN PROGRESS

## Requirementes

* Java 1.11
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

## Cleanup

```bash
$ docker-compose down
```
