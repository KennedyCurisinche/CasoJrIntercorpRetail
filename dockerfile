FROM openjdk:17
COPY target/CasoJrIntercorpRetail-0.0.1-SNAPSHOT.jar retail_springboot.jar
ENTRYPOINT ["java","-jar","/retail_springboot.jar"]