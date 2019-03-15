FROM azul/zulu-openjdk:8 as builder

COPY . /src/
WORKDIR /src
RUN ./gradlew --no-daemon fetchRuntimeDependencies bootJar

FROM azul/zulu-openjdk:8
COPY --from=builder /src/build/libs/demo-app-*.jar /opt/demo-app.jar
COPY --from=builder /src/build/libs/jmx_prometheus_javaagent-*.jar /opt/jmx_prometheus_javaagent.jar
COPY prometheus.yaml /opt/
WORKDIR /opt
EXPOSE 8080
EXPOSE 9090
CMD ["java", "-javaagent:./jmx_prometheus_javaagent.jar=9090:prometheus.yaml", "-jar", "demo-app.jar"]
