FROM registry.redhat.io/fuse7/fuse-java-openshift-jdk11-rhel8:1.9-23
#ENV JAVA_APP_DIR="/deployments"
USER root

RUN pwd

ADD  ./target/*.jar /deployments/

EXPOSE 8080 

USER 185
