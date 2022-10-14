FROM openjdk:17-slim as build

MAINTAINER company.az

COPY build/libs/cards-v-1.0.0.jar /app/

WORKDIR /app/

ENTRYPOINT ["java"]

CMD ["-jar", "/app/cards-v-1.0.0.jar"]