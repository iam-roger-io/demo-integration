#!/bin/bash

mvn clean install
podman build -t iamrogerio2/demo-integration-backend:$1 .
podman push iamrogerio2/demo-integration-backend:$1
