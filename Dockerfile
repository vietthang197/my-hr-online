FROM tomee:9-jre11-alpine-plume
COPY target/jakartaee-hello-world.war /usr/local/tomee/webapps/
