FROM maven:3-jdk-8 as builder
WORKDIR /opt/app

COPY . /opt/app
ENV MAVEN_OPTS="-Xmx1024m"


FROM openjdk:8-jre-alpine

WORKDIR /opt/app

COPY --from=builder /opt/app/store-gateway-service/target/store-gateway-service.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch store-gateway-service.jar'
ENTRYPOINT ["java","-jar","store-gateway-service.jar"]
