#!/bin/bash

./mvnw clean package -DskipTests
if [ $? -eq 0 ]; then
    cp target/CustomAnnotation-Inteceptor-0.0.1-SNAPSHOT.jar ./app.jar
fi