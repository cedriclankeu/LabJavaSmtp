#!/bin/bash
cd LabJavaSmtp
mvn clean install 
java -jar target/lab-java-smtp-1.0-SNAPSHOT-launcher.jar;
