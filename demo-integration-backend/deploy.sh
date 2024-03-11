#!/bin/bash

podman build -t iamrogerio2/demo-integration-backend:$1 .

podman push iamrogerio2/demo-integration-backend:$1 

oc new-app iamrogerio2/demo-integration-backend:$1

oc expose svc/demo-integration-backend --port=8080 --name=api-http

oc create route edge api-https --service=demo-integration-backend --port=8080

