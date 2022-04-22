# demo-integration-backend

#### Deploy MySQL Openshift

```
oc new-project demo-integration

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


## Deploy manual no Openshift 4

### Criar config map com o arquivo de properties da pasta resources/spring

```
oc create configmap  demo-integration-backend --from-file ./application.properties 
```

### Criar a aplicação
```
oc new-app iamrogerio2/demo-integration-backend:2.0

```

### bind configMap ao deploymentconfig

```
oc set volume deploymentconfig.apps.openshift.io/demo-integration-backend --add \
   --name=demo-integration-backend  \
   -m /opt/fuse \
   -t configmap \
   --configmap-name=demo-integration-backend \
   --default-mode='0777' \
   --overwrite
```

### Criar rota
```
oc create route edge api --service=demo-integration-backend --port=8080-tcp
```

Endpoints
```
<ROUTE/HOST>/geo/state/BRhttps://api-demo-integration.apps.hml.sefaz.se.gov.br/geo/state/BR
<ROUTE/HOST>/geo/state/BRhttps://api-demo-integration.apps.hml.sefaz.se.gov.br/geo/country
```