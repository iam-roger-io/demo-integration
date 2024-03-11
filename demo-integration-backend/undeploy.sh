#!/bin/bash

oc delete deployment/demo-integration-backend
oc delete service/demo-integration-backend
oc delete route api-http
oc delete route api-https
oc delete imagestream demo-integration-backend

