#!/bin/bash

mvn -f projects/movie/pom.xml clean package docker:build
mvn -f projects/user/pom.xml clean package docker:build
mvn -f projects/payment/pom.xml clean package docker:build
