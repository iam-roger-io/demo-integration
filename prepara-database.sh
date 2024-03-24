#!/bin/bash

export NAMESPACE=demo-integration
export MYSQL_SELECTOR=mysql

export MYSQL_POD=$(oc get pods  -o custom-columns=POD:.metadata.name  --no-headers --selector name=$MYSQL_SELECTOR -n $NAMESPACE)

oc rsh -n $NAMESPACE $MYSQL_POD mysql -u admin -padmin demointegrationdb < ./demo-integration-backend/database/demointegrationdb.sql 