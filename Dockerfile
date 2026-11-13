FROM eclipse-temurin:21-jdk-alpine

ARG ENV

ENV APP_NAME=top-car-exec-service
ENV DATABASE_HOST=db-top-car-postgres

RUN addgroup -S spring && adduser -S spring -G spring

RUN mkdir -p /opt/datadog/ && \
    wget -O /opt/datadog/dd-java-agent.jar https://dtdg.co/latest-java-tracer && \
    chmod -R 755 /opt/datadog/    

USER spring:spring

ARG JAR_FILE=app/target/*jar
COPY ${JAR_FILE} app.jar

RUN echo "ENV=${ENV}"

ENTRYPOINT ["java","-Xms128M","-Xmx128M","-jar", "-Dspring.profiles.active=${ENV}","-javaagent:/opt/datadog/dd-java-agent.jar", "-Ddd.agent.host=datadog-agent", "-Ddd.logs.injection=true", "-Ddd.service=${APP_NAME}", "-Ddd.env=${ENV}", "/app.jar"]
