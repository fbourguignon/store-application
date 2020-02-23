FROM maven:3-jdk-8 as builder
WORKDIR /opt/app

COPY . /opt/app
ENV MAVEN_OPTS="-Xmx1024m"
RUN mvn clean package -DskipTests


FROM openjdk:8-jre-alpine

WORKDIR /opt/app

COPY --from=builder /opt/app/store-auth-service/target/store-auth-service.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch store-auth-service.jar'
ENTRYPOINT ["java","-jar","store-auth-service.jar"]
