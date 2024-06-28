FROM eclipse-temurin:17-jre-alpine
COPY /target/kam-dnes-na-obed-1.1.jar .

EXPOSE 5000
ENTRYPOINT ["java", "-jar", "kam-dnes-na-obed-1.1.jar" ]

