FROM openjdk:11
EXPOSE 8888
COPY target/sakila.jar sakila.jar
ENTRYPOINT ["java","-jar","/sakila.jar"]
