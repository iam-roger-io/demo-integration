#!/bin/bash

podman build -t iamrogerio2/demo-integration-frontend:$1 .
podman push iamrogerio2/demo-integration-frontend:$1


