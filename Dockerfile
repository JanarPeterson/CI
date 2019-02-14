FROM openjdk:8
ADD build/libs/CI-0.0.1-SNAPSHOT.jar CI-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "CI-0.0.1-SNAPSHOT.jar"]