FROM azul/zulu-openjdk:8 as builder

COPY . /src/
WORKDIR /src
RUN ./gradlew --no-daemon bootJar

FROM azul/zulu-openjdk:8
COPY --from=builder /src/build/libs/*.jar /opt
WORKDIR /opt
RUN mv *.jar demo-app.jar
EXPOSE 8080
CMD ["java","-jar", "demo-app.jar"]
