
Configurações 

node (16 ou superior):
~~~
v16.14.2
~~~

RHSSO (a api javascript está alinhada com essa versão):
~~~
7.6.0.GA
~~~
	
Configuração do RHSSO na aplicação:
~~~
assets/config.json
~~~

~~~
{
    "keycloakUrl": "https://keycloak-helm-rhsso.apps-crc.testing/auth",
    "realm": "portal",
    "clientId": "app-angular",
    "apiBff":"http://portal-bff-portal-dev.apps-crc.testing/v1"

}
~~~

Configurações do Client
~~~
Valid Redirect URIs: http://*
Criar um client público
~~~

Instalando os pacotes da aplicação (na raiz do projeto):

Instalando cli do angular
~~~
npm install -g @angular/cli
~~~

Instalando dependências
~~~
npm install
~~~

Executando:
~~~
ng serve
~~~
obs: a aplicação precisa do rh-sso funcionando para carrgar.

Aplicação executará na porta 4200
~~~
http://localhost:4200
~~~

Build Docker Image
~~~
podman build . -t quay.io/rh_ee_fguimara/portal-front-angular:x.x.x
~~~