# demo-integration-backend

#### Deploy MySQL Openshift

```
oc new-app --template=mysql-persistent \
-p MYSQL_USER=admin \
-p MYSQL_PASSWORD=admin \
-p MYSQL_DATABASE=demointegrationdb \
-p MYSQL_ROOT_PASSWORD=root  \
-p MYSQL_VERSION=8.0-el8 \
-p VOLUME_CAPACITY=1Gi \
-p MEMORY_LIMIT=512Mi
```

Para ajustar permissões do usuário admin

```
GRANT ALL ON *.* TO 'admin'@'%';
FLUSH PRIVILEGES;

```

#### Schema e Dados

[./database/demointegrationdb.sql](./database/demointegrationdb.sql)




## Deploy on Openshift

```
oc new-app iamrogerio2/demo-integration-backend:2.0
oc set volume deploymentconfig.apps.openshift.io/demo-integration-backend --add --name=demo-integration-backend  -m /opt/fuse -t configmap --configmap-name=demo-integration-backend --default-mode='0777' --overwrite
```