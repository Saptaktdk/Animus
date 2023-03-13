#!/bin/bash

BUILD_NUMBER=2

#? Clean
./mvnw -B clean -DskipTests -DBUILD_NUMBER=$BUILD_NUMBER

#? Build
./mvnw -B package -DskipTests -DBUILD_NUMBER=$BUILD_NUMBER