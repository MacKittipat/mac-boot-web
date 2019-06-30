FROM openjdk:11

WORKDIR /app

ADD ./target/mac-boot-web-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "mac-boot-web-1.0-SNAPSHOT.jar"]
