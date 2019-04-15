Building image:
./mvnw install dockerfile:build

Running on local docker:
docker run -i --rm -p 8080:8080 -t springio/gs-spring-boot-docker
