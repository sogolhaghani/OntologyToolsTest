# Ontology Tools Developer Test

### Project Description 

This repository is about the implementation of this [link](https://github.com/EBISPOT/OntologyToolsTest/blob/main/README.md#functional-requirements).

### Dependencies
* Java 17
* Spring boot 3.1.4
* lombok
* MongoDB
* log4j
* Maven
* Docker

### Setup

To run this project:

* Download and install IntelliJ IDEA (Recommends)

* Install Docker and Docker Compose if you don't have your own database and message brokers

* Run git clone https://github.com/sogolhaghani/OntologyToolsTest.git

* Configure JDK 17 for your project on IntelliJ IDEA

* Build via : `mvnw clean spring-javaformat:apply package -B -Dmaven.test.skip=true`

* Run: `docker-compose build`

* Run: `docker-compose up`

* Open [http:localhost:8080](http:localhost:8080) in browser









