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

Importe o arquivo [./database/demointegrationdb.sql](./database/demointegrationdb.sql) para a base de dados MySQL criada no Openshift 4.

- O importe pode ser feito através de uma ferramenta como MySQL WorkBench
- Por linha de comando:

# Iniciar base de dados

```
export NAMESPACE=demo-integration
export MYSQL_SELECTOR=mysql

export MYSQL_POD=$(oc get pods  -o custom-columns=POD:.metadata.name  --no-headers --selector deployment=$MYSQL_SELECTOR -n $NAMESPACE)

oc rsh -n $NAMESPACE $MYSQL_POD mysql -u admin -padmin demointegrationdb < ./demo-integration-backend/database/demointegrationdb.sql 
```

## Provisioning the Application.

*Gerar Pacote*

```
mvn clean install
```

*Gerar Imagem com Podman*

```
podman build -t iamrogerio2/demo-integration-backend:<NOME-DA-TAG> .

podman push iamrogerio2/demo-integration-backend:<NOME-DA-TAG> 
```

*Deploy*

```
oc new-app iamrogerio2/demo-integration-backend:<NOME-DA-TAG>
```

*Rota HTTP*

```
oc expose svc/demo-integration-backend --port=8080 --name=api-http
```

*Rota HTTPS*

```
oc create route edge api-https --service=demo-integration-backend --port=8080
```

Consulte também os scripts [deploy.sh](deploy.sh) e [undeploy.sh](undeploy.sh) 

# Endpoints

*Post*
- {URL}/crud/students

Exemplo:

```
curl --location 'http://api-http-demo-integration.apps-crc.testing/crud/students' \
--header 'Content-Type: application/json' \
--data-raw '{
    
    "name" : "Kaleb Sharon",
	"email" : "ks@hieca.com",	
	"mobile" : "+55 11 54550-5579"

}'

```
*GET*

- {URL}/crud/students
- {URL}/crud/students/{ID}

Exemplo:

```
curl --location 'http://api-http-demo-integration.apps-crc.testing/crud/students'
curl --location 'http://api-http-demo-integration.apps-crc.testing/crud/students/13'
```

*DEL*

- {URL}/crud/students/{ID}

Exemplo:

```
curl --location --request DELETE 'http://api-http-demo-integration.apps-crc.testing/crud/students/13'
```
