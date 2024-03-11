#!/bin/bash

oc delete deployment/demo-integration-backend
oc delete service/demo-integration-backend
oc delete route api
oc delete imagestream demo-integration-backend

