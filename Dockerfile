FROM adoptopenjdk:11-jre-openj9
EXPOSE 8080
COPY ./target/MSPruebaTecnica-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java","-jar","./MSPruebaTecnica-0.0.1-SNAPSHOT.jar"]