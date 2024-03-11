# demo-integration-backend


## Preparando o ambiente

*Create a namespace*

``` 
oc new-project demo-integration
```

*Provisioning a MySQL database.*

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

*Schema e Dados*

Importe o arquivo [./database/demointegrationdb.sql](./database/demointegrationdb.sql) para a base de dados MySQL criada no Openshift 4


## Provisioning the Application.

*Gerar Pacote*

```
mvn clean install
```

*Gerar Imagem com Podman*

```
podman build -t iamrogerio2/demo-integration-backend:2.0 .

podman push iamrogerio2/demo-integration-backend:2.0 
```

*Deploy*

```
oc new-app iamrogerio2/demo-integration-backend:2.0
```

*Rota HTTP*

```
oc expose svc/demo-integration-backend --port=8080 --name=api-http
```

*Rota HTTPS*

```
oc create route edge api-https --service=demo-integration-backend --port=8080
```

# Endpoints

*Post*

```
curl --location 'https://api-demo-integration.apps-crc.testing/crud/person' \
--header 'Content-Type: application/json' \
--data-raw '{
    
    "name" : "Kaleb Sharon",
	"email" : "ks@hieca.com",	
	"mobile" : "+55 11 54550-5579"

}

```
*POST*

```
curl --location 'https://api-demo-integration.apps-crc.testing/crud/person'
```

*DEL*

```
curl --location --request DELETE 'https://api-demo-integration.apps-crc.testing/crud/person/13'
```
