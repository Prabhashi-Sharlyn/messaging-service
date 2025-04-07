FROM openjdk:17
ADD target/messaging-service.jar messaging-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","messaging-service.jar"]