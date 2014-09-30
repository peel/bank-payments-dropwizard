#!/bin/bash

mvn package
java -jar target/payments-1.0-SNAPSHOT.jar db migrate src/main/resources/payments.yml
java -jar target/payments-1.0-SNAPSHOT.jar server src/main/resources/payments.yml
