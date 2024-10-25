FROM maven:3.8.6-openjdk-11
COPY . .
RUN mvn clean compile package -DskipTests
FROM openjdk:17
COPY target/CasoJrIntercorpRetail-0.0.1-SNAPSHOT.jar retail_springboot.jar
ENTRYPOINT ["java","-jar","/retail_springboot.jar"]