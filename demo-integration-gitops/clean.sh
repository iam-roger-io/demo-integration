#!/bin/bash

oc delete all --all
oc delete secret/mysql
oc delete pvc mysql-pvc
oc delete service/demo-integration-backend
oc delete imagestreams/demo-integration-backend
