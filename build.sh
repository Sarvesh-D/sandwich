#!/bin/sh
cd $TRAVIS_BUILD_DIR/sandwich
mvn clean package
mvn cobertura:cobertura