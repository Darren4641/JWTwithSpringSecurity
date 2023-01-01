FROM java:11

LABEL maintainer="zxz4641@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=/out/artifacts/JWTLogin_jar

ADD ${JAR_FILE} to-do-test.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/to-do-test.jar"]