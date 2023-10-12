FROM openjdk:17-alpine
MAINTAINER ebi.ac.uk
COPY target/OntologyToolsTest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]