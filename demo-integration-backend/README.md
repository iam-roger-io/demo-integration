# demo-integration-backend


## 1 Preparando o ambiente

### 1.1 Local

*Create a MYSQL 8 instance*

```
podman run -d --name mysql \
  -e MYSQL_USER=admin \
  -e MYSQL_PASSWORD=admin \
  -e MYSQL_DATABASE=demointegrationdb \
  -e MYSQL_ROOT_PASSWORD=root \
  -v mysql_data:/var/lib/mysql \
  -p 3306:3306 \
  docker.io/mysql:8.0
```

*Import the Schema*

```
mysql  -h 127.0.0.1 -P 3306 -u admin -padmin demointegrationdb < ./demo-integration-backend/database/demointegrationdb.sql
```


### 1.2 Openshift 4

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

*Import the Schema*

Importe o arquivo [./database/demointegrationdb.sql](./database/demointegrationdb.sql) para a base de dados MySQL criada no Openshift 4.

- O importe pode ser feito através de uma ferramenta como MySQL WorkBench
- Por linha de comando:

```
export NAMESPACE=demo-integration
export MYSQL_SELECTOR=mysql

export MYSQL_POD=$(oc get pods  -o custom-columns=POD:.metadata.name  --no-headers --selector deployment=$MYSQL_SELECTOR -n $NAMESPACE)

oc rsh -n $NAMESPACE $MYSQL_POD mysql -u admin -padmin demointegrationdb < ./demo-integration-backend/database/demointegrationdb.sql 
```

## 2 Provisioning/Running the Application.

### 2.1 Local

Considerando que o MYSQL esta em execução conforme descrito no item *Preparando o ambiente*

```
mvn spring-boot:run \
  -Dspring-boot.run.arguments="--DATABASE_MYSQL_URL=jdbc:mysql://localhost:3306/demointegrationdb \
  --DATABASE_MYSQL_USERNAME=admin \
  --DATABASE_MYSQL_PASSWORD=admin"
```


### 2.2 Openshift 4

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


## 3 Endpoints

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
