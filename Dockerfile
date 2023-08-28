FROM openjdk:17-slim

ARG PROFILE
ARG OPTS

ENV PROFILE=${PROFILE}
ENV OPTS=${OPTS}
ENV TZ=America/Sao_Paulo

WORKDIR /opt/cnbs-serpro-client

COPY build/libs/cnbs-serpro-client*.jar cnbs-serpro-client.jar

SHELL ["/bin/sh", "-c"]

RUN echo "America/Sao_Paulo" > /etc/timezone

EXPOSE 8080
EXPOSE 5005

CMD java ${OPTS} -jar cnbs-serpro-client.jar --spring.profiles.active=${PROFILE}
