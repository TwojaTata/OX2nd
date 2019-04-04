#!/usr/bin/env bash
mvn clean install -q -DskipTests
java -jar target/patrykk-0.1.jar