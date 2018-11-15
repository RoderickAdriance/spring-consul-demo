FROM java:8
VOLUME /tmp
ADD service-hi-0.0.1-SNAPSHOT.jar run.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/run.jar"]
EXPOSE 8762