FROM openjdk:18-alpine
ADD target/todoProject-2-0.0.1.jar app.jar
ENTRYPOINT ["java" ,"-jar","/app.jar"]